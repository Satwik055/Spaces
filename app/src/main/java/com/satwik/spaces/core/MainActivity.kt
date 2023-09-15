package com.satwik.spaces.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.satwik.spaces.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.authentication.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.core.navigation.SetupNavGraph
import com.satwik.spaces.payments.presentation.confirmation_screen.ConfirmationScreen
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
                ConfirmationScreen()
                //SetupNavGraph(navController = rememberNavController())

            }

            //----Testing Area----//



        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}

