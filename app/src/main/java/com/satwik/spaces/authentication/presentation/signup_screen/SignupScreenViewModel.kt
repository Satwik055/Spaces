package com.satwik.spaces.authentication.presentation.signup_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.satwik.spaces.authentication.domain.use_case.signup.SignupUseCase
import com.satwik.spaces.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SignupScreenViewModel @Inject constructor(
    private  val signupUseCase: SignupUseCase)
    :ViewModel() {

    private val _state = mutableStateOf(SignupState())
    val state: State<SignupState> = _state

    init {
        signup("test01@gmail.com", "123456")
    }

    private fun signup(email:String, password:String){
        signupUseCase(email, password).onEach {result ->
            when(result){
                is Resource.Success ->{
                    _state.value = SignupState(success = true)
                }
                is Resource.Error ->{
                    _state.value = SignupState(error = result.message?:"An unexpected error occurred")
                }
                is Resource.Loading ->{
                    _state.value = SignupState(isLoading = true)
                }
            }
        }
    }
}