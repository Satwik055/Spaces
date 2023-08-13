package com.satwik.spaces.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.satwik.spaces.authentication.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.properties.presentation.theme.SpacesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpacesTheme {
                //SetupNavGraph(navController = rememberNavController())
                SignUpScreen(navController = rememberNavController())
            }

            //----Testing Area----//
            fun signupWithFirebase(email:String, password:String) = CoroutineScope(Dispatchers.IO).launch {
                val auth = FirebaseAuth.getInstance()
                auth.createUserWithEmailAndPassword(email, password).await()
            }

            signupWithFirebase("test02@gmail.com", "123456")

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}

