package com.example.basicstatecodelab.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.data.WellnessTask
import com.example.basicstatecodelab.data.WellnessTasksList
import com.example.basicstatecodelab.data.WellnessViewModel
import com.example.basicstatecodelab.helpers.StatefulCounter

@Composable
fun WellnessScreen(modifier: Modifier = Modifier, viewmodel: WellnessViewModel = viewModel()){
    //WaterCounter(modifier)
    Column(modifier = modifier) {
        StatefulCounter(modifier)
        WellnessTasksList(list = viewmodel.tasks, onCheckedTask = {task, checked -> viewmodel.changeCheckedUI(task, checked)}, onCloseTask = {task -> viewmodel.remove(task)})
    }
}
