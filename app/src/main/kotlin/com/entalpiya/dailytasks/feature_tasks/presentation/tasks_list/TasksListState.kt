package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list

import com.entalpiya.dailytasks.feature_tasks.domain.model.Task

data class TasksListState(
    val tasks: List<Task> = listOf(),
    val error: String? = null,
    val taskTitle: String = "",
    val isSplashScreenLoading: Boolean = true,
)
