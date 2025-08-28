package com.example.myviewmodel

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.myviewmodel.counterscreen.CounterScreen
import com.example.myviewmodel.countscreenLiveData.CounterScreen2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(name: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "CounterScreen2") {
        composable("CounterScreen2") {
            CounterScreen2(navController)
        }

    }
}

