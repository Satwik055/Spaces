package com.satwik.spaces.explore.presentation.explore_screen

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.satwik.spaces.core.utils.qualifiers.UserCollection
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreScreenViewModel @Inject constructor(
    @UserCollection private val userCollection: CollectionReference,
    private val firebaseAuth: FirebaseAuth
):ViewModel() {


}