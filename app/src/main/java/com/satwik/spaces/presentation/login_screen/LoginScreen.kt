package com.satwik.spaces.presentation.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satwik.spaces.R
import com.satwik.spaces.common.components.SpacesTextField
import com.satwik.spaces.presentation.theme.Black
import com.satwik.spaces.presentation.theme.Montserrat
import com.satwik.spaces.presentation.theme.Purple
import com.satwik.spaces.presentation.theme.White

@Composable
fun LoginScreen(){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(start = 8.dp, end = 8.dp)
    ){
        Column {

            IconButton(onClick = { /*TODO*/} ,
                modifier = Modifier
                    .size(45.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_caretleft),
                    contentDescription = null,
                    tint = White,
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

            Spacer(modifier = Modifier.height(30.dp))

            var emailText by remember { mutableStateOf("") }
            SpacesTextField(
                text = emailText,
                onValueChange ={emailText=it},
                placeholder = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            var passwordText by remember { mutableStateOf("") }
            SpacesTextField(
                text = passwordText,
                onValueChange ={passwordText=it},
                placeholder = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier= Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Purple)
            ) {
                Text(
                    text = "Login",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 18.sp,
                )
            }
        }
    }
}