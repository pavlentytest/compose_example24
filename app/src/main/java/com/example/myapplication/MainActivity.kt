package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarsFull()
        }
    }
}

data class Message(val author: String, val body: String)
data class Language(val name: String, val hexColor:Long)


@Composable
fun BarsFull() {
    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(title= { Text("test!!!", fontSize = 22.sp)},
                navigationIcon={ IconButton({ }) { Icon(Icons.Filled.Menu, contentDescription = "Меню")}},
                actions={
                    IconButton({ }) { Icon(Icons.Filled.Info, contentDescription = "О приложении")}
                    IconButton({ }) {Icon(Icons.Filled.Search, contentDescription = "Поиск")}
                },
                colors= TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray,
                    titleContentColor = Color.LightGray,
                    navigationIconContentColor = Color.LightGray,
                    actionIconContentColor = Color.LightGray))
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.DarkGray,
                contentColor = Color.LightGray
            ){
                IconButton(onClick = {  }) { Icon(Icons.Filled.Favorite, contentDescription = "Избранное")}
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = {  }) { Icon(Icons.Filled.Info, contentDescription = "Справка")}
            }
        }
    ){
        Text("Hello METANIT.COM", fontSize = 28.sp, modifier = Modifier.padding(it))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars() {
    TopAppBar(title= { Text("Test", fontSize = 22.sp)},
        navigationIcon={ IconButton({ }) { Icon(Icons.Filled.Menu, contentDescription = "Меню")}},
        actions={
            IconButton({ }) { Icon(Icons.Filled.Info, contentDescription = "О приложении")}
            IconButton({ }) {Icon(Icons.Filled.Search, contentDescription = "Поиск")}
        })
}

@Composable
fun Containers() {

    val langs = listOf(Language("Kotlin",0xff16a085),
        Language("Java",0xff2980b9),
        Language("JavaScript",0xffe74c3c),
        Language("Python", 0xffd35400))
    Column{
        for(lang in langs){
            Row(modifier = Modifier.padding(10.dp).fillMaxWidth()){
                Box(modifier=Modifier.size(50.dp).background(Color(lang.hexColor)))
                Text(text = lang.name, fontSize = 28.sp, modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
fun MessageCard2(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}
@Composable
fun MessageCard(msg: Message) {
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewMessageCard() {
  //  MessageCard(
 //       msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
 //   )
    BarsFull()
   // Containers()
}

