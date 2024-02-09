package com.satwik.spaces.properties.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import com.satwik.spaces.authentication.domain.model.User
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import com.satwik.spaces.properties.presentation.detail_screen.PropertyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    @UserCollection private val userCollection: CollectionReference,
    private val firebaseAuth: FirebaseAuth
):ViewModel() {


}