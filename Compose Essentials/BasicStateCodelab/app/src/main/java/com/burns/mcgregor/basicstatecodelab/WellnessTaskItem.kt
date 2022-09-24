package com.burns.mcgregor.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.burns.mcgregor.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessTaskItem(taskName:String, modifier: Modifier = Modifier){
    var checkedState by rememberSaveable{ mutableStateOf(false)}

    WellnessTaskItem(taskName = taskName,
        checked = checkedState,
        onCheckedChanged = {newValue -> checkedState = newValue},
        onClose = { /*TODO*/ },
        modifier = modifier)
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean, onCheckedChanged: (Boolean) -> Unit,
    onClose: () -> Unit, modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = taskName, modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(checked = checked, onCheckedChange = onCheckedChanged)
        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodelabTheme() {
        WellnessTaskItem(taskName = "My Task", checked = false,
            onCheckedChanged = {},
            onClose = { /*TODO*/ })
    }
}