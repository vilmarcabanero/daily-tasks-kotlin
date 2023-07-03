package com.entalpiya.dailytasks.feature_tasks.domain.use_case

import com.entalpiya.dailytasks.feature_tasks.domain.model.Task
import com.entalpiya.dailytasks.feature_tasks.domain.repository.TasksRepository
import javax.inject.Inject

class DeleteTask @Inject constructor(private val repository: TasksRepository) {
    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
    }
}