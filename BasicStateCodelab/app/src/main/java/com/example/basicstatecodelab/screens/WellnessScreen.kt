package com.example.basicstatecodelab.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.helpers.WaterCounter

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    WaterCounter(modifier)
}