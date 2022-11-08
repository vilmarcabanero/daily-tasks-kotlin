package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
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
            TaskInput(modifier = Modifier.weight(0.07f), props = TaskInputProps(state, setTaskTitle, onInsertTask))
        }
    }
}