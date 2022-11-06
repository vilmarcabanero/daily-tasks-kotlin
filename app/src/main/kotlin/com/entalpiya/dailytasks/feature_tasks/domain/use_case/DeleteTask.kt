package com.entalpiya.dailytasks.feature_tasks.domain.use_case

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.dailytasks.feature_tasks.domain.repository.TasksRepository
import javax.inject.Inject

class DeleteTask @Inject constructor(private val repository: TasksRepository) {
    suspend operator fun invoke(task: TaskEntity) {
        repository.deleteTask(task)
    }
}