package com.satwik.spaces.core

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.core.navigation.SetupNavGraph
import com.satwik.spaces.properties.presentation.location_screen.LocationScreen
import com.satwik.spaces.core.theme.SpacesTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpacesTheme {
                SetupNavGraph(navController = rememberNavController())
                //LocationScreen(navController = rememberNavController())

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}

