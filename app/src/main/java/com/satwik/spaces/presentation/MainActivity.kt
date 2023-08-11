package com.satwik.spaces.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.satwik.spaces.common.Constants
import com.satwik.spaces.domain.model.Property
import com.satwik.spaces.presentation.home_screen.HomeScreen
import com.satwik.spaces.presentation.login_screen.LoginScreen
import com.satwik.spaces.presentation.navigation.SetupNavGraph
import com.satwik.spaces.presentation.signup_screen.SignUpScreen
import com.satwik.spaces.presentation.theme.SpacesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpacesTheme {
                //SetupNavGraph(navController = rememberNavController())
                LoginScreen()
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}

