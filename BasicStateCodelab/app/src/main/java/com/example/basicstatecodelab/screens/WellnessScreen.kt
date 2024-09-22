package com.example.basicstatecodelab.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.data.WellnessTasksList
import com.example.basicstatecodelab.helpers.StatefulCounter

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    //WaterCounter(modifier)
    Column(modifier = modifier) {
        StatefulCounter(modifier)
        WellnessTasksList()
    }
}