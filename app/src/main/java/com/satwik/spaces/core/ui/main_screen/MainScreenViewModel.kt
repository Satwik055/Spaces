package com.satwik.spaces.core.ui.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satwik.spaces.common.domain.model.User
import com.satwik.spaces.common.domain.use_case.GetCurrentSpacesUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentSpacesUser: GetCurrentSpacesUserUseCase
):ViewModel() {

    private val _user=  mutableStateOf(User())
    val user: State<User> = _user

    init {
        getCurrentSpacesUser()
    }

    private fun getCurrentSpacesUser(){
        viewModelScope.launch{
            _user.value = getCurrentSpacesUser.invoke()
        }
    }
}