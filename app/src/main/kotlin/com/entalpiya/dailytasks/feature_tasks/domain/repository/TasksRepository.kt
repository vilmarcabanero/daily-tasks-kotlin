package com.entalpiya.dailytasks.feature_tasks.domain.repository

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskMakeCompleteEntity

interface TasksRepository {
    suspend fun getTasks(): List<TaskEntity>
    suspend fun insertTask(TaskEntity: TaskEntity)
    suspend fun deleteTask(TaskEntity: TaskEntity)
    suspend fun makeCompleteTask(id: String, value: Boolean)
}

