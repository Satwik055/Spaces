package com.satwik.spaces.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satwik.spaces.R
import com.satwik.spaces.presentation.detail_screen.DetailScreen
import com.satwik.spaces.presentation.home_screen.HomeScreen
import com.satwik.spaces.presentation.home_screen.components.ListingCard
import com.satwik.spaces.presentation.theme.SpacesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}