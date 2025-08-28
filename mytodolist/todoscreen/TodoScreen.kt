package com.example.mytodolist.todoscreen

import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun TodoScreen(navController: NavController, viewModel: TodoViewModel = viewModel()) {
    val viewModelTodo by viewModel.toDoList.collectAsState()
    val newTodo by viewModel.newItem.collectAsState()
    var checked by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            androidx.compose.material3.FloatingActionButton(
                onClick = { viewModel.addTodo() },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "To Do"
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "오늘 할 일(MVVM)",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                value = newTodo,
                onValueChange = { viewModel.updateNewItem(it) },
                placeholder = { Text("새로운 할 일") },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                if (viewModelTodo.isEmpty()) {
                    item {
                        Text(text = "할 일이 없습니다. 추가해보세요!")
                    }
                } else {
                    items(viewModelTodo.size) { index ->
                        Row {
                            Checkbox(
                                checked = checked,
                                onCheckedChange = { checked = !checked }
                            )
                            Text(
                                text = viewModelTodo[index],
                                fontSize = 20.sp,
                                textDecoration = if (checked == true) TextDecoration.LineThrough else TextDecoration.None,
                                modifier = Modifier
                                    .weight(1f)
                                )
                            IconButton(
                                onClick = { viewModel.deleteTodo(index) }
                            ) {
                                Icon(Icons.Filled.Delete, contentDescription = "Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}