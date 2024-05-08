package com.satwik.auth.presentation.login_screen

import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satwik.auth.common.AuthenticationState
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

    var isFormValidated by remember { mutableStateOf(false) }
    val emailAuthState = viewModel.emailAuthState.value
    val formState = viewModel.formState.value
    val context = LocalContext.current

    LaunchedEffect(context) {
        viewModel.validationEvents.collect{ event->
            when(event){
                is LoginScreenViewModel.ValidationEvent.Success ->{
                    isFormValidated = true
                }
            }
        }
    }

    when{
        emailAuthState.error.isNotBlank() -> {
            LaunchedEffect(Unit) {
                Toast.makeText(context, emailAuthState.error, Toast.LENGTH_SHORT).show()
            }
        }
        emailAuthState.successfull->
            LaunchedEffect(Unit){
                navController.navigate(Screen.Main.route){
                    popUpTo(Graph.Auth.route) { inclusive=true}
                }
            }
    }

    Content(
        viewModel = viewModel,
        navController = navController,
        formState = formState,
        emailAuthState = emailAuthState ,
        isFormValidated = isFormValidated,
    )
}

@Composable
internal fun Content(
    navController: NavController,
    viewModel: LoginScreenViewModel,
    formState: LoginFormState,
    emailAuthState: AuthenticationState,
    isFormValidated: Boolean,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){

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

        SpacesTextField(
            text = formState.email,
            onValueChange ={viewModel.onEvent(LoginFormEvent.EmailChanged(it))},
            placeholder = "Email",
            errorText = formState.emailError?:"",
            isError = formState.emailError != null,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        SpacesTextField(
            text = formState.password,
            onValueChange ={viewModel.onEvent(LoginFormEvent.PasswordChanged(it))},
            isPassword = true,
            placeholder = "Password",
            isError = formState.passwordError != null,
            errorText = formState.passwordError?:"",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(75.dp))

        SpacesButton(
            text = "Login",
            type = when(emailAuthState.isLoading){
                true -> ButtonType.LOADING
                false -> ButtonType.REGULAR
            },
            onClick = {
                viewModel.onEvent(LoginFormEvent.Submit)
                if(isFormValidated){
                    viewModel.login(formState.email, formState.password)
                }
            },
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = buildAnnotatedString {
                append("Don't have an account ? ")
                withStyle(style = SpanStyle(color = Purple)){
                    append("Signup")
                }
            },
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { navController.navigate(Screen.Signup.route) }
        )
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}