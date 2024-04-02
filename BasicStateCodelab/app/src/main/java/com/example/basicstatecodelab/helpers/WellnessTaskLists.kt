package com.example.basicstatecodelab.helpers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.basicstatecodelab.data.WellnessTask

fun getWellnessTasks() = List(30){i -> WellnessTask(i, "Task # $i")}

@Composable
fun WellnessTasksList(modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier,
                      list:List<WellnessTask> = remember { getWellnessTasks() }){
    LazyColumn(modifier = modifier) {
        items(list) {task -> WellnessTaskItem(taskName = task.label)}
    }
}