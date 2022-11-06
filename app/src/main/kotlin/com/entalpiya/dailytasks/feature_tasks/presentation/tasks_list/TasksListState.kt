package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity

data class TasksListState(
    val tasks: List<TaskEntity> = listOf(),
    val error: String? = null,
    val taskTitle: String = "",
)
