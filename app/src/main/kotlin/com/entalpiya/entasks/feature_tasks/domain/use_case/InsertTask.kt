package com.entalpiya.entasks.feature_tasks.domain.use_case

import com.entalpiya.entasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.entasks.feature_tasks.domain.repository.TasksRepository
import javax.inject.Inject

class InsertTask @Inject constructor(private val repository: TasksRepository) {
    suspend operator fun invoke(task: TaskEntity){
        repository.insertTask(task)
    }
}