package com.example.basicstatecodelab.helpers

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier){
    val count = 0
    Text(text = "You've had $count glasses", modifier.padding(16.dp))
}




@Preview(name = "Water Counter Preview")
@Composable
fun WaterCounterPreview(){
    BasicStateCodelabTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            WaterCounter()
        }
    }
}