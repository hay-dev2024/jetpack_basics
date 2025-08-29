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
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// 특정 메모 상세보기(삭제, 수정 기능 포함)
@Composable
fun DetailScreen(navController: NavController, viewModel: HomeViewModel, memoId: Int?) {
    val memo = memoId?.let { viewModel.getMemoById(it) }

    Scaffold(
        topBar = {
            SharedTopbar()
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Column() {
                    if (memo != null) {
                        Text(
                            text = "제목: ${memo.title}",
                            modifier = Modifier
                                .padding(16.dp)
                        )

                        HorizontalDivider(thickness = 2.dp)

                        Text(
                            text = "내용:\n${memo.content}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f)

                ) {
                    Text(text = "홈으로")
                }

                Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                Button(
                    onClick = {
                        memoId?.let { id ->
                            navController.navigate("EditMemoScreen/$id")
                        }
                    },
                    modifier = Modifier.weight(1f)

                ) {
                    Text(text = "수정하기")
                }

                Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                Button(
                    onClick = {
                        memoId?.let { id ->
                            viewModel.deleteMemo(id)
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier.weight(1f)

                ) {
                    Text(text = "삭제하기")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
