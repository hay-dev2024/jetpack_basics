package com.example.mynavcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
//fun Counter(navController: NavController, text: String = "default") {
fun Counter(navController: NavController) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
    ) {
        Text(
            "Count: $count",
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        ) {
            Button(
                onClick = { count++ }
            ) {
                Text(text = "증가")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = { count-- }
            ) {
                Text(text = "감소")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = { count = 0 }
            ) {
                Text(text = "리셋")
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        // 넘어온 데이터 보여주기
//        Text(
//            text = text,
//            fontFamily = FontFamily.Cursive,
//
//            modifier = Modifier
//                .padding(10.dp)
//                .background(color = Color.Yellow)
//        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = { navController.navigate("Home") }) {
            Text("Home으로 이동")
        }
    }

}