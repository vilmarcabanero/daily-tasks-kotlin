package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.unit.dp

import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskItem

@Composable
fun TasksListScreen(
    state: State<TasksListState>,
    onTaskClick: (id: String, oldValue: Boolean) -> Unit,
    setTaskTitle: (taskTitle: String) -> Unit,
    onInsertTask: (taskTitle: String) -> Unit,
) {
    Column() {
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier
            .fillMaxSize()
            .weight(0.9f)) {
            LazyColumn {
                items(state.value.tasks) {
                    TaskItem(it) { id, oldValue ->
                        onTaskClick(id, oldValue)
                    }
                }
            }
            state.value.error?.let { Text(it) }
        }
        Row(modifier = Modifier
            .height(50.dp)
            .weight(0.07f)) {
            BasicTextField(value = state.value.taskTitle,
                onValueChange = { setTaskTitle(it) },
                decorationBox = { innerTextField ->
                    Row(Modifier
                        .background(LightGray, RoundedCornerShape(percent = 30))
                        .padding(16.dp)) {
                        innerTextField()
                    }
                },
                modifier = Modifier
                    .weight(1f))
            IconButton(onClick = { onInsertTask(state.value.taskTitle) },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
        }
    }
}