package com.example.basicstatecodelab.helpers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme



@Composable
fun StatelessCounter(count:Int, onIncrement:() -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0){
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text(text = "Add One")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable{ mutableIntStateOf(0)}
    StatelessCounter(count = count, onIncrement = { count++ }, modifier)
}




@Preview(name = "Water Counter Preview")
@Composable
fun WaterCounterPreview(){
    BasicStateCodelabTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            StatefulCounter(modifier = Modifier)
        }
    }
}