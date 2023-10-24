package com.example.mychess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessBoard()
        }
    }
}

//@Composable
//private fun ChessBox(){
//    Box(modifier = Modifier.padding(horizontal = 100.dp, vertical = 200.dp)){
//        Column(){
//            for (i in 0..7){
//                Row(){
//                    for (j in 0..7){
//                        Box(modifier = Modifier
//                            .width(25.dp)
//                            .height(25.dp)
//                            .background(if ((i + j) % 2 == 0) Color.White else Color.Black)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}

@Composable
fun ChessBoard() {
    val letters = listOf("a", "b", "c", "d", "e", "f", "g", "h")
    val numbers = (1..8).toList().reversed()

    Box(modifier = Modifier.border(2.dp, Color.Green).fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Spacer(modifier = Modifier.width(16.dp))
                letters.forEach { letter ->
                    Text(
                        text = letter,
                        modifier = Modifier.width(32.dp).graphicsLayer { rotationZ = 180f },
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                LazyColumn {
                    items(numbers) { number ->
                        Text(
                            text = number.toString(),
                            modifier = Modifier.height(32.dp).padding(bottom = 4.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                LazyColumn {
                    items(8) { rowIndex ->
                        LazyRow {
                            items(8) { columnIndex ->
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .background(if ((rowIndex + columnIndex) % 2 == 0) Color.White else Color.Gray)
                                )
                            }
                        }
                    }
                }
                LazyColumn {
                    items(numbers.reversed()) { number ->
                        Text(
                            text = number.toString(),
                            modifier = Modifier.height(32.dp).graphicsLayer { rotationZ = 180f },
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
            Row {
                Spacer(modifier = Modifier.width(16.dp))
                letters.forEach { letter ->
                    Text(
                        text = letter,
                        modifier = Modifier.width(32.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}