package com.example.mytodolist

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytodolist.todoscreen.TodoScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(name: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "TodoScreen") {

        composable("TodoScreen") {
                    TodoScreen(navController)
        }
    }
}