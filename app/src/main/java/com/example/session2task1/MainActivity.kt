package com.example.session2task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.session2task1.ui.theme.Session2Task1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Session2Task1Theme {
                Box(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}


@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    /*var textState by remember { mutableStateOf("") }
    val list = listOf(1, 2, 3, 4, 5)*/

    val postsState by viewModel.postModelsState.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.End) {
        items(postsState){
             MyText(text = it.title)
        }
    }

    /*Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.End
    ) {
        TextField(value = textState, onValueChange = { textState = it })
        Text(text = "Youssef Ahmed", fontSize = 12.sp)
        Text(text = "Youssef Ahmed", fontSize = 12.sp)

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(list) { MyText(it.toString()) } }

        Box(modifier = Modifier.fillMaxWidth()){
            Text(modifier = Modifier.align(Alignment.Center), text = "Youssef Ahmed", fontSize = 12.sp)
            Text(text = "Ahmed Ahmed", fontSize = 12.sp)
        }
    }*/ }
@Composable
fun MyText(text: String) {
    Text(text = text, fontSize = 10.sp, color = Color.Green)
}

@Preview(showBackground = true, showSystemUi = true, device = "id:Nexus One")
@Composable
fun GreetingPreview() {
    Session2Task1Theme {
        MainScreen()
    }
}