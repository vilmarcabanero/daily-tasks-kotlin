package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListState
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListViewModel

@Composable
fun TaskList(modifier: Modifier, props: TaskListProps) {
    Box(contentAlignment = Alignment.TopStart, modifier = modifier
        .fillMaxSize()) {
        LazyColumn {
            items(props.vm.state.value.tasks) {
                TaskItem(it) { id, oldValue ->
                    props.vm.makeCompleteTask(id, oldValue)
                }
            }
        }
        props.vm.state.value.error?.let { Text(it) }
    }
}

data class TaskListProps(
    val vm: TasksListViewModel,
)