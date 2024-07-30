package com.example.basicstatecodelab.helpers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable {mutableStateOf(0)}
    WaterCounter(count, {count++}, modifier)
}


@Composable
fun WaterCounter(count:Int,onIncrement:() -> Unit,modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {

            Text(
                text = "You've had $count glasses."
            )
            Button(
                onClick = { onIncrement() },
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }
    }
}