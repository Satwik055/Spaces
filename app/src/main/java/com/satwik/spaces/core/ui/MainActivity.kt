package com.satwik.spaces.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.core.navigation.setup.SetupNavGraph
import com.satwik.spaces.core.ui.theme.SpacesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition{!viewModel.isReady.value}
        }

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

