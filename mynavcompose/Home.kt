package com.example.mynavcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    var text by remember { mutableStateOf("") }
    val previousEntry = navController.previousBackStackEntry
    val savedStateHandle = previousEntry?.savedStateHandle

    val userId = savedStateHandle?.get<String>("userId") ?: ""
    val userPw = savedStateHandle?.get<String>("userPw") ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
    ) {
        Text("아이디: $userId")
        Text("비밀번호: $userPw")


        Text(
            "Home",
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
                .background(color = Color.Blue)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = text,
            onValueChange = { NewText -> text = NewText },
            label = { Text("Start typing!") },
            modifier = Modifier
                .padding(10.dp)
        )

//        Text(
//            text = "$text",
//            fontFamily = FontFamily.Cursive,
//
//            modifier = Modifier
//                .padding(10.dp)
//                .background(color = Color.Yellow)
//        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = { navController.navigate("Counter") },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Counter로 이동")
        }


        // 데이터 보내기
//        Button(
//            onClick = { navController.navigate("Counter/testtext!!!!") },
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//        ) {
//            Text("Counter로 이동")
//        }


    }

}