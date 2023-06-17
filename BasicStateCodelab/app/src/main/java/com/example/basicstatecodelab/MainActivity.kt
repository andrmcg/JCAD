package com.example.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun StatelessCounter(modifier: Modifier = Modifier, count:Int, onIncrement:() -> Unit) {
    Column() {
        if (count > 0) {
            Text(text = "You've had ${count} glasses.", modifier = Modifier.padding(16.dp))
        }
        Button(
            onClick = onIncrement,Modifier.padding(top = 8.dp), enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable{ mutableStateOf(0)}
    StatelessCounter(modifier,count,{count++})
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)
        WellnessTasksList()
    }
}

@Composable
fun WellnessTaskItem(taskName: String,
                     checked:Boolean,
                     onCheckedChange:(Boolean) -> Unit,
                     onClose: () -> Unit,
                     modifier: Modifier = Modifier) {
    var checkedState by remember{ mutableStateOf(false)}
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = taskName, modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Composable
fun WellnessTaskItem(taskName:String, modifier: Modifier = Modifier){
    var checkedState by rememberSaveable{ mutableStateOf(false)}
    WellnessTaskItem(taskName = taskName, checked = checkedState,
        onCheckedChange = {newValue -> checkedState = newValue}
        , onClose = { }, modifier = modifier)
}

@Preview(showBackground = true, name = "WaterCounter Preview")
@Composable
fun WaterCounterPreview() {
    StatefulCounter(Modifier)
}

@Preview(showBackground = true, name = "Wellness Task Item Preview")
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodelabTheme {
        WellnessTaskItem(taskName = "Task 1",true, onClose = { }, onCheckedChange = {})
    }
}

@Preview(
    showBackground = true, showSystemUi = true, name = "Wellness Screen Preview",
    device = Devices.PIXEL_4_XL
)
@Composable
fun WellnessScreenPreview() {
    BasicStateCodelabTheme() {
        WellnessScreen()
    }
}