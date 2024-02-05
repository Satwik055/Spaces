package com.satwik.spaces.authentication.presentation.signup_screen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.authentication.OneTapSignInState
import com.satwik.spaces.authentication.domain.use_case.OneTapSignInUseCase
import com.satwik.spaces.authentication.domain.use_case.SignupUseCase
import com.satwik.spaces.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SignupScreenViewModel @Inject constructor(
    private  val signupUseCase: SignupUseCase,
    private val oneTapSignInUseCase: OneTapSignInUseCase
) :ViewModel() {

    private val _state = mutableStateOf(SignupUiState())
    val state: State<SignupUiState> = _state

    private val _oneTapSignInState = mutableStateOf(OneTapSignInState())
    val oneTapSignInState: State<OneTapSignInState> = _oneTapSignInState

    fun oneTapSignIn(tokenId:String){
        oneTapSignInUseCase(tokenId).onEach {result->
            when(result){
                is Resource.Error -> _oneTapSignInState.value = OneTapSignInState(error = result.message)
                is Resource.Success -> _oneTapSignInState.value = OneTapSignInState(successfull = true)
                is Resource.Loading -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun signup(email:String, password:String, username:String){
        signupUseCase(email, password, username).onEach {result->
            when(result){
                is Resource.Error -> _state.value = SignupUiState(error = result.message)
                is Resource.Loading -> _state.value = SignupUiState(isLoading = true)
                is Resource.Success -> _state.value = SignupUiState(user = result.data)
            }
        }.launchIn(viewModelScope)
    }
}
