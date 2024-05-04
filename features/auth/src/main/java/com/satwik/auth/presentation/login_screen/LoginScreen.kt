package com.satwik.auth.presentation.login_screen

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satwik.common.Graph
import com.satwik.common.Screen
import com.satwik.designsystem.components.ButtonType
import com.satwik.designsystem.components.SpacesButton
import com.satwik.designsystem.components.SpacesTextField
import com.satwik.designsystem.theme.Purple
import com.satwik.designsystem.theme.White

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = hiltViewModel(),
){

    val state = viewModel.state.value
    var errorText by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){
        Column{

            Spacer(modifier = Modifier.height(14.dp))

            IconButton(onClick = {/*TODO*/} ,
                modifier = Modifier
                    .size(45.dp)
            ) {
                Icon(
                    painter = painterResource(id = com.satwik.designsystem.R.drawable.ic_caretleft),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.offset(x= (-10).dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Please login to continue",
                style = MaterialTheme.typography.titleMedium
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
                isPassword = true,
                placeholder = "Password",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(75.dp))

            SpacesButton(
                text = "Login",
                type =
                when(state.isLoading){
                    true -> ButtonType.LOADING
                    false -> ButtonType.REGULAR
                }

            ) { viewModel.login(emailText, passwordText) }
        }

        Text(
            text = buildAnnotatedString {
                append("Don't have an account ? ")
                withStyle(style = SpanStyle(color = Purple)){
                    append("Signup")
                }
            },
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable { navController.navigate(Screen.Signup.route) }
        )

        }
        if (state.error?.isNotEmpty() == true) {
            isError = true
            errorText = state.error.toString()
        }

        state.user?.let {
            LaunchedEffect(Unit){
                navController.navigate(Screen.Main.route){
                    popUpTo(Graph.Auth.route) { inclusive=true}
                }
            }
        }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}