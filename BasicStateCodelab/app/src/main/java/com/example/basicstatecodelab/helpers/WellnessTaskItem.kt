package com.example.basicstatecodelab.helpers

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessTaskItem(taskName:String, onClose: () -> Unit,modifier: Modifier = Modifier){
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = taskName, modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp))
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Preview(name = "Wellness Task Item Preview")
@Composable
fun WellnessTaskItemPreview(){
    BasicStateCodelabTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            WellnessTaskItem(taskName = "Test", onClose = { /*TODO*/ })
        }
    }
}