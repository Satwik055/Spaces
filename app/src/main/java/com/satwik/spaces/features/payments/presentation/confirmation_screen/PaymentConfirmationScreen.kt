package com.satwik.spaces.features.payments.presentation.confirmation_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.satwik.spaces.R
import com.satwik.spaces.core.navigation.objects.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun PaymentConfirmationScreen(
    navController: NavController
) {

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit){
        scope.launch {
            delay(3000)
            navController.navigate(Screen.Main.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {

        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.confirmation_tick_animation))

        Column (
        modifier = Modifier
            .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LottieAnimation(
                modifier = Modifier.size(150.dp),
                composition = composition,
                iterations = 1,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Payment Successfull",
                style = MaterialTheme.typography.titleMedium,
            )
        }

    }
}



@Preview
@Composable
fun PaymentConfirmationScreenPreview(){
}
