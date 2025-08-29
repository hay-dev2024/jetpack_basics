package com.example.mynoteapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(name: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val sharedViewModel: HomeViewModel = viewModel()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") { HomeScreen(navController, sharedViewModel) }
        composable("AddMemoScreen") { AddMemoScreen(navController, sharedViewModel) }
        composable("DetailScreen/{memoId}") { backStackEntry ->
            val memoId = backStackEntry.arguments?.getString("memoId")?.toIntOrNull()
            DetailScreen(navController, sharedViewModel, memoId)
        }
        composable("EditMemoScreen/{memoId}") { backStackEntry ->
            val memoId = backStackEntry.arguments?.getString("memoId")?.toIntOrNull()
            EditMemoScreen(navController, sharedViewModel, memoId)
        }
    }
}