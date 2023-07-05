package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListState
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListViewModel

@Composable
fun TaskInput(modifier: Modifier, props: TaskInputProps) {

    Column(modifier = modifier) {
        Row(modifier = Modifier
            .padding(3.dp)
            .padding(end = 6.dp),
        verticalAlignment = Alignment.Bottom) {
            TextField(
                value = props.vm.state.value.taskTitle,
                onValueChange = { props.vm.setTaskTitle(it) },
                placeholder = { Text(text = "New task") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor =  MaterialTheme.colors.background
                ),
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { props.vm.insertTask(props.vm.state.value.taskTitle) }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add", tint = MaterialTheme.colors.primary)
            }
        }
    }
}

data class TaskInputProps(
    val vm: TasksListViewModel,
)