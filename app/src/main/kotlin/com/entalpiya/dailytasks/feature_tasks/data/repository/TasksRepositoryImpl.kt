package com.entalpiya.dailytasks.feature_tasks.data.repository

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.TasksDao
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskMakeCompleteEntity
import com.entalpiya.dailytasks.feature_tasks.domain.repository.TasksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TasksRepositoryImpl(
    private val dao: TasksDao
): TasksRepository {
    override suspend fun getTasks(): List<TaskEntity> {
        return withContext(Dispatchers.IO) {
            return@withContext dao.getAll()
        }
    }

    override suspend fun insertTask(task: TaskEntity) = withContext(Dispatchers.IO) {
        dao.insertTask(task)
    }

    override suspend fun deleteTask(task: TaskEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun makeCompleteTask(id: String, value: Boolean) = withContext(Dispatchers.IO) {
        dao.makeCompleteTask(TaskMakeCompleteEntity(id = id, isCompleted = value))
    }
}