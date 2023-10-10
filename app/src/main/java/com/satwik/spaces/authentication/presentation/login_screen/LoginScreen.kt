package com.satwik.spaces.authentication.presentation.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.spaces.R
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.components.SpacesTextField
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.core.utils.Resource
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Montserrat
import com.satwik.spaces.core.theme.Purple
import com.satwik.spaces.core.theme.White

@Composable
fun LoginScreen(
    navController:NavController,
    viewModel:LoginScreenViewModel = hiltViewModel()
){

    val loginFlow = viewModel.loginFlow.collectAsState()
    var errorText by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp)
    ){
        Column {

            Spacer(modifier = Modifier.height(14.dp))

            IconButton(onClick = {/*TODO*/} ,
                modifier = Modifier
                    .size(45.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_caretleft),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.offset(x= (-10).dp)

                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Login",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 34.sp,
            )

            Text(
                text = "Please login to continue",
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(53.dp))

            var emailText by remember { mutableStateOf("") }
            SpacesTextField(
                text = emailText,
                onValueChange ={emailText=it},
                placeholder = "Email",
                errorText = errorText,
                isError = isError,
                modifier = Modifier
                    .fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(15.dp))

            var passwordText by remember { mutableStateOf("") }
            SpacesTextField(
                text = passwordText,
                onValueChange ={passwordText=it},
                placeholder = "Password",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(75.dp))

            SpacesButton(
                text = "Login",
                onClick = {viewModel.login(emailText, passwordText)}
            )
        }

        Text(
            text = "Don't have an account ? Signup",
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            color = White,
            fontSize = 13.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable { navController.navigate(Screen.Signup.route) }
        )

        loginFlow.value?.let {
            when(it){
                is Resource.Loading->{
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = Purple
                    )
                }
                is Resource.Success->{
                    LaunchedEffect(Unit){
                        navController.navigate(Screen.Home.route){
                            popUpTo(Screen.Home.route) {inclusive=true}
                        }
                    }
                }
                is Resource.Error->{
                    isError = true
                    errorText = it.message.toString()
                }
            }
        }
    }
}