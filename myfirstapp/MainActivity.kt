package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme


class MainActivity : ComponentActivity() {
    // 진입점
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContent 안에서 작업을 하면 된다.
        setContent {
            // 프로그램 전역 theme 설정; 람다함수
            MyFirstAppTheme {
                // 화면뼈대 잡기
                Scaffold(
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // composable method
                    Greeting(
                        name = "Kotlin",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// @Composable(annotation이다) --> UI 구성요소를 만들기 위한 함수이다; main thread에서 동작한다.
// modifier 로 작업한다(색상, padding 등)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") } // 람다인 mutableStateOf(상태값)의 값을 remember가 캐싱한다

    Column {
        Text(
            text = "Hello, $name!",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            color = Color.Yellow,
            textAlign = TextAlign.Center,

            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Blue)
                .size(width = 180.dp, height = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "123",

            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {  },
            modifier = Modifier
                .padding(10.dp)
                .size(width = 120.dp, height = 40.dp)

        ) {
            Text("난 버튼이야")
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { NewText -> text = NewText },
            label = { Text("여기에 입력하시오") },
            modifier = Modifier
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color.Gray,
            shadowElevation = 10.dp,
            modifier = Modifier
                .padding(10.dp)

        ) {
            Text(
                text = "$text",
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                fontSize = 20.sp,

                modifier = Modifier
//                    .background(color = Color.Blue)
                    .size(width = 280.dp, height = 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row () {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text("버튼1")
            }

            Spacer(Modifier.weight(1f))

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text("버튼2")
            }
        }

        Box (
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
            ){
                Text("Box 버튼")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting1(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf(0) }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My First App",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                )}
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription="Enter To Dos")
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selected == 0,
                    onClick = {selected = 0},
                    icon = {Text(text="🏠")},
                    label = {Text(text="Home")}
                )
            }

//            BottomAppBar {
//                Text(
//                    text = "App Bar",
//                    color = Color.Blue,
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.Serif,
//                    fontStyle = FontStyle.Italic,
//                    textAlign = TextAlign.Center,
//
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(10.dp)
//
//                )
//            }
        },

    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(
                text = "Hello, $name!",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                color = Color.Yellow,
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .padding(10.dp)
                    .background(color = Color.Blue)
                    .size(width = 180.dp, height = 40.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = "123",

                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .padding(10.dp)
                    .size(width = 120.dp, height = 40.dp)

            ) {
                Text("난 버튼이야")
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = text,
                onValueChange = { NewText -> text = NewText },
                label = { Text("여기에 입력하시오") },
                modifier = Modifier
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color.Gray,
                shadowElevation = 10.dp,
                modifier = Modifier
                    .padding(10.dp)

            ) {
                Text(
                    text = "$text",
                    color = Color.White,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 20.sp,

                    modifier = Modifier
//                    .background(color = Color.Blue)
                        .size(width = 280.dp, height = 50.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row() {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text("버튼1")
                }

                Spacer(Modifier.weight(1f))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text("버튼2")
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text("Box 버튼")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


        }
    }

}


@Composable
fun CountEx() {
    var count by remember { mutableStateOf(0) }

    Column {
        Text(
            "count: $count",
            modifier = Modifier
                .padding(10.dp)
        )
        Button(onClick = { count++ }, colors = ButtonDefaults.buttonColors(Color.LightGray)) {
            Text("+1 증가")
        }
    }
}



// Preview 랜더링 관련
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
//        Greeting1("Kotlin")
        CountEx()
    }
}