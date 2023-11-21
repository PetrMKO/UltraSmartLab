package com.example.mega

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
//                    .background(Color(256))
            ) {
                itemsIndexed(
                    listOf(
                        ItemRowModel(R.drawable.rock, "Скала", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis nec mattis lorem. Curabitur porttitor sollicitudin fermentum. Donec efficitur libero vel purus imperdiet, non egestas arcu varius. Sed vel pulvinar eros. Proin quis turpis metus. Curabitur fringilla feugiat urna, vel euismod."),
                        ItemRowModel(R.drawable.rock, "Скала", "Test"),
                        ItemRowModel(R.drawable.rock, "Скала", "Test"),
                        ItemRowModel(R.drawable.rock, "Скала", "Test"),
                        ItemRowModel(R.drawable.rock, "Скала", "Test"),
                        ItemRowModel(R.drawable.rock, "Скала", "Test"),
                    )) { _, item ->
                        ItemCard(item = item)
                }
            }
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun Content() {
//    LazyColumn(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//        ) {
//        itemsIndexed(
//            listOf("Item1", "item2")
//        ){ index, item ->
//            Text(
//                text = item + index,
//                fontSize = 30.sp,
//                modifier = Modifier.padding(vertical = 5.dp)
//            )
//        }
//    }
//}
//
//@Composable
//private fun CircleButton() {
//    val counter = remember {
//        mutableStateOf(0)
//    }
//    val color = remember {
//        mutableStateOf(Color.Black)
//    }
//
//    Box(
//        modifier = Modifier
//            .size(100.dp)
//            .background(color = color.value, shape = CircleShape)
//            .clickable {
//                when (++counter.value) {
//                    10 -> color.value = Color.Blue
//                    20 -> color.value = Color.Green
//                }
//            },
//        contentAlignment = Alignment.Center
//    ){
//        Text(
//            text = counter.value.toString(),
//            style = TextStyle(color = Color.White, fontSize = 20.sp)
//        )
//    }
//
//}
//
//@Composable
//private fun ListItem(name: String, prof: String) {
//    var counter = remember {
//        mutableStateOf(0)
//    }
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//            .clickable {
//                counter.value++
//            },
//        shape = RoundedCornerShape(15.dp),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 5.dp
//        )
//    ) {
//        Box(modifier = Modifier.height(64.dp)) {
//            Row() {
//                Image(
//                    painter = painterResource(id = R.drawable.rock), contentDescription = "image",
//                    contentScale = ContentScale.Fit,
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .clip(CircleShape)
//                )
//                Column(
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .padding(start = 16.dp),
//                    verticalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Text(text = counter.value.toString())
//                    Text(text = prof)
//                }
//            }
//        }
//
//    }
//}