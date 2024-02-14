package com.satwik.spaces.features.authentication.presentation.login_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.data.auth.domain.use_case.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private  val loginUseCase: LoginUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(LoginUiState())
    val state: State<LoginUiState> = _state

    fun login(email:String, password:String){
        loginUseCase(email, password).onEach {result->
            when(result){
                is Resource.Error -> _state.value = LoginUiState(error = result.message)
                is Resource.Loading -> _state.value = LoginUiState(isLoading = true)
                is Resource.Success -> _state.value = LoginUiState(user = result.data)
            }
        }.launchIn(viewModelScope)
    }
}
