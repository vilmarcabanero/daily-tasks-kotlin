package com.entalpiya.entasks.feature_tasks.domain.use_case

import com.entalpiya.entasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.entasks.feature_tasks.domain.repository.TasksRepository
import javax.inject.Inject

class GetTasks @Inject constructor(private val repository: TasksRepository) {
    suspend operator fun invoke(): List<TaskEntity> {
        return repository.getTasks().filter { !it.isCompleted }
    }
}