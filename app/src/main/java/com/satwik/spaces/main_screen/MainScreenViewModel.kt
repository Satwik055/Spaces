package com.satwik.spaces.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.auth.domain.repository.AuthRepository
import com.satwik.auth.domain.use_case.GetCurrentSpacesUserUseCase
import com.satwik.common.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentSpacesUser: GetCurrentSpacesUserUseCase,
    private val authRepository: AuthRepository
):ViewModel() {

    private val _user=  mutableStateOf(User())
    val user: State<User> = _user

    init {
        //Gets current user to display it in nav-drawer header
        getCurrentSpacesUser()
    }

    private fun getCurrentSpacesUser(){
        viewModelScope.launch{
            _user.value = getCurrentSpacesUser.invoke()
        }
    }

    fun logout(){
        authRepository.logout()
    }
}