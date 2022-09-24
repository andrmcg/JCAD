package com.burns.mcgregor.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>, onCloseTask:(WellnessTask) -> Unit) {
    //val listState = rememberLazyListState()
    //val scope = rememberCoroutineScope()
    LazyColumn(modifier = modifier /*, state = listState*/ ){
        items(list, key = {task -> task.id}){task ->
            WellnessTaskItem(taskName = task.label, onClose = {onCloseTask(task)})
        }
        //scope.launch { listState.scrollToItem(10) }
    }

}



