package com.example.mynavcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTopbar() {
    TopAppBar(
        title = {
            Text(
                text = "My App",
                color = Color.Yellow,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Blue)
                    .padding(10.dp)
            )
        }
    )
}

@Composable
fun SharedBottomBar(navController: NavController) {
    var selected by remember { mutableStateOf(0) }

    NavigationBar {
        NavigationBarItem(
            selected = selected == 0,
            onClick = {navController.navigate("Home")},
            icon = {Text(text = "🏠")},
            label = {Text(text = "Home")}
        )
        NavigationBarItem(
            selected = selected == 1,
            onClick = {navController.navigate("Counter")},
            icon = {Text(text = "🧮")},
            label = {Text(text = "Counter")}
        )
        NavigationBarItem(
            selected = selected == 2,
            onClick = {navController.navigate("Contact")},
            icon = {Text(text = "☎️")},
            label = {Text(text = "Contact")}
        )
    }
}
