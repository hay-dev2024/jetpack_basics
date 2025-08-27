package com.example.mynavcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController) {
    val backStackEntry = navController.currentBackStackEntry
    val savedStateHandle = backStackEntry?.savedStateHandle

    var userId by remember { mutableStateOf(savedStateHandle?.get<String>("userId") ?: "") }
    var userPw by remember { mutableStateOf(savedStateHandle?.get<String>("userPw") ?: "") }

    LaunchedEffect(userId, userPw) {
        savedStateHandle?.set("userId", userId)
        savedStateHandle?.set("userPw", userPw)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()

    )
    {
        Text(
            text = "로그인하세요",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )

        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(
            value = userId,
            onValueChange = { newUserId -> userId = newUserId },
            placeholder = {Text("아이디를 입력해주세요")},
            maxLines = 1,

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        )

        Spacer(modifier = Modifier.padding(3.dp))


        OutlinedTextField(
            value = userPw,
            onValueChange = { newUserPw -> userPw = newUserPw },
            placeholder = {Text("비밀번호를 입력해주세요")},
            maxLines = 1,

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {
                if (userId == "admin" && userPw == "1234") {
                    navController.navigate("Home")
                    } else {
                    navController.navigate("Login")
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)

        ) {
            Text("로그인")
        }




    }
}