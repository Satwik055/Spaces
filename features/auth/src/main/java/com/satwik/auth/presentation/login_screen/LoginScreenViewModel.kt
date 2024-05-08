package com.satwik.auth.presentation.login_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.auth.common.AuthenticationState
import com.satwik.auth.domain.use_case.LoginUseCase
import com.satwik.auth.domain.use_case.login_precondition.ValidateEmailUsecase
import com.satwik.auth.domain.use_case.login_precondition.ValidatePasswordUsecase
import com.satwik.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val validateEmailUsecase: ValidateEmailUsecase,
    private val validatePasswordUsecase: ValidatePasswordUsecase
) : ViewModel() {

    private val _emailAuthState = mutableStateOf(AuthenticationState())
    val emailAuthState: State<AuthenticationState> = _emailAuthState

    private val _formState = mutableStateOf(LoginFormState())
    val formState: State<LoginFormState> = _formState

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent){
        when(event){
            is LoginFormEvent.EmailChanged ->
                _formState.value = _formState.value.copy(email = event.email)
            is LoginFormEvent.PasswordChanged ->
                _formState.value = _formState.value.copy(password = event.password)
            LoginFormEvent.Submit ->
                submitData()
        }
    }

    private fun submitData() {
        val emailResult = validateEmailUsecase.execute(_formState.value.email)
        val passwordResult = validatePasswordUsecase.execute(_formState.value.password)

        val hasError = listOf(
            emailResult,
            passwordResult,
        ).any{!it.successfull}

        if(hasError){
            _formState.value = _formState.value.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
            )
        }
        else{
            viewModelScope.launch {
                validationEventChannel.send(ValidationEvent.Success)
            }
        }
    }


    fun login(email:String, password:String){
        loginUseCase(email, password).onEach {result->
            when(result){
                is Resource.Error -> _emailAuthState.value = AuthenticationState(error = result.message.toString())
                is Resource.Loading -> _emailAuthState.value = AuthenticationState(isLoading = true)
                is Resource.Success -> _emailAuthState.value = AuthenticationState(successfull = true)
            }
        }.launchIn(viewModelScope)
    }

    sealed class ValidationEvent{
        object Success:ValidationEvent()
    }

}
