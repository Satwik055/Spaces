package com.satwik.spaces.authentication.presentation.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.satwik.spaces.authentication.domain.repository.AuthRepository
import com.satwik.spaces.core.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private  val authRepository: AuthRepository
) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow : StateFlow<Resource<FirebaseUser>?> = _loginFlow

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading()
        val result = authRepository.login(email, password)
        _loginFlow.value = result
    }

    fun getCurrentUser(){
        authRepository.getCurrentUser()
    }

    fun logout(){
        authRepository.logout()
    }

}
