package com.example.checklist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ListItem("Oreo", "Api 5")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
                ListItem("KitKat", "Api 4")
            }
        }
    }

}

@Composable
private fun ListItem(name: String, prof: String) {

    val counter = remember {
        mutableStateOf(0)
    }

    val color = remember {
        mutableStateOf(Color.LightGray)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress { change, dragAmount ->
                    Log.d("PressLong", "$dragAmount")
                }
            }
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    Text(name)
                    Text(text = counter.value.toString())
                }

                Box(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .background(color = color.value, shape = CircleShape)
                        .size(40.dp)
                        .clickable {
                            when (++counter.value) {
                                10 -> color.value = Color.Red
                                20 -> color.value = Color.Green
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = counter.value.toString(),
                        style = TextStyle(color = Color.Black, fontSize = 20.sp)
                    )
                }
            }
        }
    }
}

