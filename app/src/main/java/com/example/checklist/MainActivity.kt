package com.example.checklist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
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

    @Composable
    private fun ListItem(name: String, prof: String) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Log.d("logThis", "Clicked")
                }
                .pointerInput(Unit){
                    detectDragGesturesAfterLongPress { change, dragAmount ->
                        Log.d("PressLong", "$dragAmount")
                    }
                }
                .padding(10.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Box() {
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.android),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .padding(5.dp)
                    )
                    Column (modifier = Modifier.padding(start = 15.dp)) {
                        Text(name)
                        Text(prof)
                    }
                }
            }
        }
    }
}


