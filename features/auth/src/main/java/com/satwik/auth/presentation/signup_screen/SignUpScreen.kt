package com.satwik.auth.presentation.signup_screen


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satwik.auth.presentation.signup_screen.states.AuthenticationState
import com.satwik.auth.presentation.signup_screen.states.SignupFormState
import com.satwik.common.Constants.CLIENT_ID
import com.satwik.common.Graph
import com.satwik.common.Screen
import com.satwik.designsystem.components.ButtonType
import com.satwik.designsystem.components.SpacesButton
import com.satwik.designsystem.components.SpacesTextField
import com.satwik.designsystem.theme.Black
import com.satwik.designsystem.theme.Purple
import com.satwik.designsystem.theme.White
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState


@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignupScreenViewModel = hiltViewModel(),
){
    val emailAuthState = viewModel.emailAuthState.value
    val googleAuthState = viewModel.googleAuthState.value
    val formState = viewModel.formState.value
    val context = LocalContext.current
    var isFormValidated by remember { mutableStateOf(false) }
    val tapState = rememberOneTapSignInState()

    OneTapSignInWithGoogle(
        state = tapState,
        clientId = CLIENT_ID,
        onTokenIdReceived = { tokenId -> viewModel.oneTapSignIn(tokenId) },
        onDialogDismissed = { message -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show() }
    )

    LaunchedEffect(context) {
        viewModel.validationEvents.collect{ event->
            when(event){
                is SignupScreenViewModel.ValidationEvent.Success ->{
                    isFormValidated = true
                }
            }
        }
    }

    when{
        emailAuthState.error.isNotBlank() || googleAuthState.error.isNotBlank() ->
            LaunchedEffect(Unit) {
                Toast.makeText(context, emailAuthState.error, Toast.LENGTH_SHORT ).show()
            }
        googleAuthState.error.isNotBlank() ->
            LaunchedEffect(Unit) {
                Toast.makeText(context,googleAuthState.error, Toast.LENGTH_SHORT ).show()
            }

        emailAuthState.successfull || googleAuthState.successfull ->
            LaunchedEffect(Unit){
                navController.navigate(Screen.Main.route){
                    popUpTo(Graph.Auth.route) {inclusive=true} 
                } 
            }
    }

    Content(
        viewModel = viewModel,
        navController = navController,
        formState = formState,
        emailAuthState = emailAuthState,
        googleAuthState = googleAuthState,
        isFormValidated = isFormValidated,
        tapState = tapState
    )
}

@Composable
internal fun Content(
    viewModel: SignupScreenViewModel,
    navController: NavController,
    formState: SignupFormState,
    emailAuthState: AuthenticationState,
    googleAuthState: AuthenticationState,
    isFormValidated: Boolean,
    tapState: OneTapSignInState
    ) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 16.dp, end = 16.dp)
    ){

        Spacer(modifier = Modifier.height(14.dp))

        IconButton(
            onClick = {/*TODO*/},
            modifier = Modifier
                .size(45.dp)
                .align(Alignment.Start)
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
            text = "Sign Up",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Please signup to continue",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(53.dp))

        SpacesTextField(
            text = formState.name,
            onValueChange ={viewModel.onEvent(SignupFormEvent.NameChanged(it))},
            isError = formState.nameError != null,
            errorText = formState.nameError?:"",
            placeholder = "Name",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        SpacesTextField(
            text = formState.email,
            onValueChange ={ viewModel.onEvent(SignupFormEvent.EmailChanged(it)) },
            isError = formState.emailError != null,
            errorText = formState.emailError?:"",
            placeholder = "Email",
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(15.dp))

        SpacesTextField(
            text = formState.password,
            onValueChange = { viewModel.onEvent(SignupFormEvent.PasswordChanged(it)) },
            placeholder = "Password",
            isPassword = true,
            errorText = formState.passwordError?:"",
            isError = formState.passwordError != null,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        SpacesButton(
            text = "Signup",
            type = when(emailAuthState.isLoading){
                true -> ButtonType.LOADING
                false -> ButtonType.REGULAR
            },
            onClick = {
                viewModel.onEvent(SignupFormEvent.Submit)
                if(isFormValidated){
                    viewModel.signup(formState.email, formState.password, formState.name)
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        PrivacyPolicyText()

        Spacer(modifier = Modifier.height(50.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(30.dp))

        SpacesButton(
            text = "Continue with google",
            color = White,
            fontSize = 16.sp,
            textColor = Black,
            onClick = { tapState.open() },
            type = when (googleAuthState.isLoading) {
                true -> ButtonType.LOADING
                false -> ButtonType.REGULAR
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        LoginText(
            onClick = { navController.navigate(Screen.Login.route) },
        )
    }
}

@Composable
fun LoginText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Text(
        modifier = modifier.clickable { onClick.invoke() },
        style = MaterialTheme.typography.labelSmall,
        text = buildAnnotatedString {
            append("Already have an account ? ")
            withStyle(style = SpanStyle(color = Purple)){
                append("Login")
            }
        },
    )
}

@Composable
fun PrivacyPolicyText() {
    Text(
        text = buildAnnotatedString {
            append("By signing up you agree our ")
            withStyle(style = SpanStyle(color = Purple)) {
                append("Privacy Policy ")
            }
            append("and ")
            withStyle(style = SpanStyle(color = Purple)) {
                append("Terms and Conditions")
            }
        },
        style = MaterialTheme.typography.labelSmall,
    )
}