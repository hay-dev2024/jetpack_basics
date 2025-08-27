package com.example.mynavcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(name: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "Login") {
            composable("Home") {
                Scaffold(
                    topBar = { SharedTopbar() },
                    bottomBar = { SharedBottomBar(navController) }
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Home(navController)
                    }
                }
            }

            composable("Counter") {
                Scaffold(
                    topBar = { SharedTopbar() },
                    bottomBar = { SharedBottomBar(navController) }
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Counter(navController)
                    }
                }
            }

            composable("Contact") {
                Scaffold(
                    topBar = { SharedTopbar() },
                    bottomBar = { SharedBottomBar(navController) }
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Contact(navController)
                    }
                }
            }

            composable("Login") {
                Login(navController)
            }

    }
}













//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppNavigation(name: String, modifier: Modifier = Modifier) {
//    val navController = rememberNavController()
//
//    Scaffold (
//        topBar = { SharedTopbar() },
//        bottomBar = { SharedBottomBar(navController) }
//
//    ) { innerPadding ->
//
//        Column(modifier = Modifier.padding(innerPadding)) {
//            NavHost(navController = navController, startDestination = "Login") {
//                composable("Home") { Home(navController) }
//                composable("Counter") { Counter(navController) }
//                composable ("Contact"){ Contact(navController) }
//
//
//                // 데이터 넘기기
////                composable("Counter/{text}") { backStackEntry ->
////                    val text: String? = backStackEntry.arguments?.getString("text")
////                    Counter(navController, text ?: "null")
////                }
//            }
//        }
//    }
//}

//@Composable
//fun LoginNav(name: String, modifier: Modifier = Modifier) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "Login") {
//        composable("Login") { Login(navController) }
//    }
//}