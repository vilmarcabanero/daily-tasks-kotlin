package com.entalpiya.dailytasks.feature_tasks.domain.use_case

import com.entalpiya.dailytasks.feature_tasks.domain.repository.TasksRepository
import javax.inject.Inject

class MakeComplete @Inject constructor(private val repository: TasksRepository) {
    suspend operator fun invoke(id: String, value: Boolean) {
        repository.makeCompleteTask(id = id, value = value)
    }
}