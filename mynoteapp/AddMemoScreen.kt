package com.example.mynoteapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

// 새 메모 작성(제목/내용 입력)
@Composable
fun AddMemoScreen(navController: NavController, viewModel: HomeViewModel) {
    val newTitle by viewModel.newMemoTitle.collectAsState()
    val newContent by viewModel.newMemoContent.collectAsState()

    Scaffold(
        topBar = {
            SharedTopbar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "메모를 작성하세요")

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = newTitle,
                onValueChange = { viewModel.updateNewMemoTitle(it) },
                placeholder = { Text("제목을 입력하세요") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = newContent,
                onValueChange = { viewModel.updateNewMemoContent(it) },
                placeholder = { Text("내용을 입력하세요") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        viewModel.addMemo()
                        navController.popBackStack()
                  },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "저장")
                }

                Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "취소")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}