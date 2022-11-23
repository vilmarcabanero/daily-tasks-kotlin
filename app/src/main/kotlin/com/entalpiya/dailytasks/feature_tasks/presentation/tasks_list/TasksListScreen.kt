package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskInput
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskInputProps

import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskList
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskListProps
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskTitle
@Composable
fun TasksListScreen(
    state: State<TasksListState>,
    onTaskClick: (id: String, oldValue: Boolean) -> Unit,
    setTaskTitle: (taskTitle: String) -> Unit,
    onInsertTask: (taskTitle: String) -> Unit,
) {
    Surface() {
        Column {
            TaskTitle()
            TaskList(modifier = Modifier.weight(0.8f), props = TaskListProps(state = state, onTaskClick = onTaskClick))
            TaskInput(modifier = Modifier, props = TaskInputProps(state, setTaskTitle, onInsertTask))
        }
    }
}