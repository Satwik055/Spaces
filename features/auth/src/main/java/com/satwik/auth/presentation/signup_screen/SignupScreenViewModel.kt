package com.satwik.auth.presentation.signup_screen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.auth.common.AuthenticationState
import com.satwik.auth.domain.use_case.OneTapSignInUseCase
import com.satwik.auth.domain.use_case.SignupUseCase
import com.satwik.auth.domain.use_case.signup_precondition.ValidateEmailUsecase
import com.satwik.auth.domain.use_case.signup_precondition.ValidateNameUsecase
import com.satwik.auth.domain.use_case.signup_precondition.ValidatePasswordUsecase
import com.satwik.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignupScreenViewModel @Inject constructor(
    private  val signupUseCase: SignupUseCase,
    private val oneTapSignInUseCase: OneTapSignInUseCase,
    private val validateEmailUsecase: ValidateEmailUsecase,
    private val validatePasswordUsecase: ValidatePasswordUsecase,
    private val validateNameUsecase: ValidateNameUsecase
) :ViewModel() {

    private val _emailAuthState = mutableStateOf(AuthenticationState())
    val emailAuthState: State<AuthenticationState> = _emailAuthState

    private val _formState = mutableStateOf(SignupFormState())
    val formState: State<SignupFormState> = _formState

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    private val _googleAuthState = mutableStateOf(AuthenticationState())
    val googleAuthState: State<AuthenticationState> = _googleAuthState

    fun oneTapSignIn(tokenId:String){
        oneTapSignInUseCase(tokenId).onEach {result->
            when(result){
                is Resource.Error -> _googleAuthState.value = AuthenticationState(error = result.message.toString())
                is Resource.Success -> _googleAuthState.value = AuthenticationState(successfull = true)
                is Resource.Loading -> {_googleAuthState.value = AuthenticationState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun signup(email:String, password:String, username:String){
        signupUseCase(email, password, username).onEach {result->
            when(result){
                is Resource.Error -> _emailAuthState.value = AuthenticationState(error = result.message.toString())
                is Resource.Loading -> _emailAuthState.value = AuthenticationState(isLoading = true)
                is Resource.Success -> _emailAuthState.value = AuthenticationState(successfull = true)
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event:SignupFormEvent){
        when(event){
            is SignupFormEvent.EmailChanged ->{
                _formState.value = _formState.value.copy(email = event.email)
            }
            is SignupFormEvent.PasswordChanged ->{
                _formState.value = _formState.value.copy(password = event.password)
            }
            is SignupFormEvent.NameChanged -> {
                _formState.value = _formState.value.copy(name = event.name)
            }

            is SignupFormEvent.Submit -> {
                submitData()
            }


        }
    }

    private fun submitData() {
        val emailResult = validateEmailUsecase.execute(_formState.value.email)
        val passwordResult = validatePasswordUsecase.execute(_formState.value.password)
        val nameResult = validateNameUsecase.execute(_formState.value.name)

        val hasError = listOf(
            emailResult,
            passwordResult,
            nameResult
        ).any{!it.successfull}

        if(hasError){
            _formState.value = _formState.value.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                nameError = nameResult.errorMessage
            )
        }
        else{
            viewModelScope.launch {
                validationEventChannel.send(ValidationEvent.Success)
            }
        }
    }

    sealed class ValidationEvent{
        object Success:ValidationEvent()
    }
}
