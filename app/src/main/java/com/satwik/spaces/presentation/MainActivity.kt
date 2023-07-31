package com.satwik.spaces.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.satwik.spaces.presentation.home_screen.HomeScreen
import com.satwik.spaces.presentation.navigation.SetupNavGraph
import com.satwik.spaces.presentation.theme.SpacesTheme


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