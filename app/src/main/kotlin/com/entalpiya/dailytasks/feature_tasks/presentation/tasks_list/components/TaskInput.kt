package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListState

@Composable
fun TaskInput(modifier: Modifier, props: TaskInputProps) {
    Row(modifier = modifier.height(50.dp).padding(3.dp).padding(end = 6.dp)) {
        BasicTextField(value = props.state.value.taskTitle,
            onValueChange = { props.setTaskTitle(it) },
            decorationBox = {
                Box(Modifier.padding(12.dp)) {
                    if (props.state.value.taskTitle.isEmpty()) {
                        Text("New task", style = TextStyle(fontSize = 16.sp, color = Color(0xFF8d8d8d)))
                    }
                    it()
                }
            },
            modifier = Modifier.weight(1f),
            textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onBackground),
            cursorBrush = SolidColor(MaterialTheme.colors.primary))
        IconButton(onClick = { props.onInsertTask(props.state.value.taskTitle) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add", tint = MaterialTheme.colors.primary)
        }
    }
}

data class TaskInputProps(
    val state: State<TasksListState>,
    val setTaskTitle: (taskTitle: String) -> Unit,
    val onInsertTask: (taskTitle: String) -> Unit,
)