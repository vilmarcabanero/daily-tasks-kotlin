package com.entalpiya.dailytasks.feature_tasks.data.repository

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.TasksDao
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.LocalTask
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskMakeCompleteEntity
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task
import com.entalpiya.dailytasks.feature_tasks.domain.repository.TasksRepository
import com.entalpiya.dailytasks.feature_tasks.domain.util.ConvertTask
import com.entalpiya.dailytasks.feature_tasks.domain.util.ConvertTasks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TasksRepositoryImpl(
    private val dao: TasksDao
): TasksRepository {
    override suspend fun getTasks(): List<Task> {
        return withContext(Dispatchers.IO) {
            val tasks = dao.getAll()
            return@withContext ConvertTasks().fromLocal(tasks)
        }
    }

    override suspend fun insertTask(task: Task) = withContext(Dispatchers.IO) {
        dao.insertTask(ConvertTask().toLocal(task))
    }

    override suspend fun deleteTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun makeCompleteTask(id: String, value: Boolean) = withContext(Dispatchers.IO) {
        dao.makeCompleteTask(TaskMakeCompleteEntity(id = id, isCompleted = value))
    }
}