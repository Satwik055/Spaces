package com.satwik.auth.presentation.login_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.auth.domain.use_case.LoginUseCase
import com.satwik.auth.domain.use_case.precondition.ValidateEmailUsecase
import com.satwik.auth.domain.use_case.precondition.ValidatePasswordUsecase
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
    private  val loginUseCase: LoginUseCase,
    private val validateEmailUsecase: ValidateEmailUsecase,
    private val validatePasswordUsecase: ValidatePasswordUsecase
) : ViewModel() {

    private val _state = mutableStateOf(LoginUiState())
    val state: State<LoginUiState> = _state

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

        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }


    fun login(email:String, password:String){
        loginUseCase(email, password).onEach {result->
            when(result){
                is Resource.Error -> _state.value = LoginUiState(error = result.message)
                is Resource.Loading -> _state.value = LoginUiState(isLoading = true)
                is Resource.Success -> _state.value = LoginUiState(user = result.data)
            }
        }.launchIn(viewModelScope)
    }

    sealed class ValidationEvent{
        object Success:ValidationEvent()
    }

}
