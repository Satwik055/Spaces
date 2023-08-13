package com.satwik.spaces.authentication.presentation.signup_screen


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
class SignupScreenViewModel @Inject constructor(
    private  val authRepository: AuthRepository
) :ViewModel() {

    private val _signupFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signupFlow :StateFlow<Resource<FirebaseUser>?> = _signupFlow

    fun signup(email: String, password: String) = viewModelScope.launch {
        _signupFlow.value = Resource.Loading()
        val result = authRepository.signup(email, password)
        _signupFlow.value = result
    }

    fun getCurrentUser(){
        authRepository.getCurrentUser()
    }

    fun logout(){
        authRepository.logout()
    }
}
