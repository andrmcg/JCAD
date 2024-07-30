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
import com.example.basicstatecodelab.helpers.StatefulWaterCounter
import com.example.basicstatecodelab.helpers.WaterCounter
import com.example.basicstatecodelab.models.WellnessViewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier, wellnessViewModel: WellnessViewModel = viewModel()){
    Column(modifier = modifier)
    {
        StatefulWaterCounter()
        val list = wellnessViewModel.tasks
        WellnessTasksList(list = list,onCloseTask = {task -> wellnessViewModel.remove(task)},
            onCheckedTask = {task,checked -> wellnessViewModel.changeTaskChecked(task,checked)})
    }
}