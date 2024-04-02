package com.example.basicstatecodelab.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicstatecodelab.helpers.StatefulCounter
import com.example.basicstatecodelab.helpers.WellnessTasksList
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList()
    }
}


@Preview(name = "Wellness Screen Preview", device = Devices.PIXEL_4_XL, showBackground = true, showSystemUi = true)
@Composable
fun WaterCounterPreview(){
    BasicStateCodelabTheme {
        Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
            WellnessScreen()
        }
    }
}