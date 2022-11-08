package com.entalpiya.dailytasks.feature_tasks.domain.repository

import com.entalpiya.dailytasks.feature_tasks.domain.model.Task

interface TasksRepository {
    suspend fun getTasks(): List<Task>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun makeCompleteTask(id: String, value: Boolean)
}

