package com.satwik.spaces.authentication.presentation.signup_screen


import android.util.Log
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
import androidx.compose.material3.Divider
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ramcosta.composedestinations.annotation.Destination
import com.satwik.spaces.R
import com.satwik.spaces.core.components.ButtonType
import com.satwik.spaces.core.components.SpacesButton
import com.satwik.spaces.core.components.SpacesTextField
import com.satwik.spaces.core.navigation.Screen
import com.satwik.spaces.core.theme.Black
import com.satwik.spaces.core.theme.Purple
import com.satwik.spaces.core.theme.White
import com.satwik.spaces.core.utils.Constants.CLIENT_ID
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState

@Destination
@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignupScreenViewModel = hiltViewModel(),
){

    val state = viewModel.state.value
    val oneTapSignInState = viewModel.oneTapSignInState.value

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

            IconButton(onClick = { /*TODO*/},
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.Start)
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
                text = "Sign Up",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Please signup to continue",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(53.dp))

            var nameText by remember { mutableStateOf("") }
            SpacesTextField(
                text = nameText,
                onValueChange ={nameText=it},
                placeholder = "Name",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(15.dp))

            var emailText by remember { mutableStateOf("") }
            SpacesTextField(
                text = emailText,
                onValueChange ={emailText=it},
                placeholder = "Email",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(15.dp))

            var passwordText by remember { mutableStateOf("") }
            SpacesTextField(
                text = passwordText,
                onValueChange ={passwordText=it},
                placeholder = "Password",
                errorText = errorText,
                isError = isError,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            SpacesButton(
                text = "Signup",
                type =
                when(state.isLoading){
                    true -> ButtonType.LOADING
                    false -> ButtonType.REGULAR
                }
            ) {viewModel.signup(emailText, passwordText)}

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = buildAnnotatedString {
                    append("By signing up you agree our ")
                    withStyle(style = SpanStyle(color = Purple)){
                        append("Privacy Policy ")
                    }
                    append("and ")
                    withStyle(style = SpanStyle(color = Purple)){
                        append("Terms and Conditions")
                    }
                },
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .clickable { navController.navigate(Screen.Login.route) }
            )

            Spacer(modifier = Modifier.height(50.dp))

            Divider()

            Spacer(modifier = Modifier.height(30.dp))

            val tapState = rememberOneTapSignInState()
            OneTapSignInWithGoogle(
                state = tapState,
                clientId = CLIENT_ID,
                onTokenIdReceived = { tokenId -> viewModel.oneTapSignIn(tokenId) },
                onDialogDismissed = { message -> errorText = message }
            )

            SpacesButton(
                text = "Continue with google",
                color = White,
                fontSize = 16.sp,
                textColor = Black
            ) { tapState.open() }
        }

        Text(
            text = buildAnnotatedString {
                append("Already have an account ? ")
                withStyle(style = SpanStyle(color = Purple)){
                    append("Login")
                }
            },
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable { navController.navigate(Screen.Login.route) }
        )

        if(oneTapSignInState.successfull){
            LaunchedEffect(Unit){
                navController.navigate(Screen.Home.route)
            }
        }

        if(state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Purple
            )
        }
        if (state.error?.isNotEmpty() == true){
            isError = true
            errorText = state.error.toString()
        }

        state.user?.let {
            LaunchedEffect(Unit){
                navController.navigate(Screen.Home.route){
                    popUpTo(Screen.Home.route) {inclusive=true}
                }
            }
        }
    }
}