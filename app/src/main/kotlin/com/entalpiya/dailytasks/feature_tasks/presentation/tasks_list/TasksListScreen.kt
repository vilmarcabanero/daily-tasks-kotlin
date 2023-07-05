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
import androidx.hilt.navigation.compose.hiltViewModel
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskInput
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskInputProps

import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskList
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskListProps
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components.TaskTitle
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun TasksListScreen(vm: TasksListViewModel = hiltViewModel()) {
    Surface {
        Column {
            TaskTitle()
            TaskList(modifier = Modifier.weight(0.8f), props = TaskListProps(vm))
            TaskInput(modifier = Modifier, props = TaskInputProps(vm))
        }
    }
}
