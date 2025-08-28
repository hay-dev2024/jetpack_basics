package com.example.myviewmodel.countscreenLiveData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun CounterScreen2(navController: NavController, viewModel: CounterViewModel = viewModel()) {
    val viewModelCount by viewModel.counter.observeAsState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "ViewModel LiveData 사용 카운트: $viewModelCount",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp),
        )

        Button(
            onClick = {viewModel.incrementCounter()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            ),
        ) { Text("LiveData 사용 증가 카운트") }

        Button(
            onClick = {viewModel.decrementCounter()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB00020),
                contentColor = Color.White
            ),
        ) { Text("LiveData 사용 감소 카운트") }

        Button(
            onClick = {viewModel.resetCounter()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF03DAC5),
                contentColor = Color.White
            ),
        ) { Text("LiveData 사용 리셋 카운트") }
    }




}