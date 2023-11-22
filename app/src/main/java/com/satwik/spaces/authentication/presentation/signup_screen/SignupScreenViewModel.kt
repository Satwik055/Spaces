package com.satwik.spaces.authentication.presentation.signup_screen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.authentication.domain.use_case.SignupUseCase
import com.satwik.spaces.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SignupScreenViewModel @Inject constructor(
    private  val signupUseCase: SignupUseCase
) :ViewModel() {

    private val _state = mutableStateOf(SignupUiState())
    val state: State<SignupUiState> = _state

    fun signup(email:String, password:String){
        signupUseCase(email, password).onEach {result->
            when(result){
                is Resource.Error -> _state.value = SignupUiState(error = result.message)
                is Resource.Loading -> _state.value = SignupUiState(isLoading = true)
                is Resource.Success -> _state.value = SignupUiState(user = result.data)
            }
        }.launchIn(viewModelScope)
    }
}
