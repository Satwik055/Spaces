package com.satwik.spaces.core

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.registerForActivityResult
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.LocationServices
import com.satwik.spaces.core.navigation.SetupNavGraph
import com.satwik.spaces.properties.presentation.location_screen.LocationScreen
import com.satwik.spaces.core.theme.SpacesTheme
import com.satwik.spaces.core.utils.DefaultLocationClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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

