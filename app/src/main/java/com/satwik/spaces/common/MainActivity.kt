package com.satwik.spaces.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.authentication.presentation.login_screen.LoginScreen
import com.satwik.spaces.properties.presentation.navigation.SetupNavGraph
import com.satwik.spaces.properties.presentation.theme.SpacesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpacesTheme {
                SetupNavGraph(navController = rememberNavController())
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}

