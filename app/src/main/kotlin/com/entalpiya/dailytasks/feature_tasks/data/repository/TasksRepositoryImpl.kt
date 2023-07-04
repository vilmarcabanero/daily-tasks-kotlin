package com.entalpiya.dailytasks.feature_tasks.data.repository

import com.entalpiya.dailytasks.feature_tasks.data.data_source.api.TasksApiService
import com.entalpiya.dailytasks.feature_tasks.data.data_source.api.payload.CreateTaskPayload
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.TasksDao
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskMakeCompleteEntity
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task
import com.entalpiya.dailytasks.feature_tasks.domain.repository.TasksRepository
import com.entalpiya.dailytasks.feature_tasks.domain.util.ConvertTask
import com.entalpiya.dailytasks.feature_tasks.domain.util.ConvertTasks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor (
    private val restInterface: TasksApiService,
    private val dao: TasksDao
): TasksRepository {

    override suspend fun getTasks(): List<Task> {
        return withContext(Dispatchers.IO) {
            val remoteTasks = getRemoteTasks()
            val localTasks = getLocalTasks()
            return@withContext remoteTasks
        }
    }

    override suspend fun insertTask(task: Task): Unit = withContext(Dispatchers.IO) {
//        insertTaskLocal(task)
        createTaskRemote(CreateTaskPayload(task.title))
    }

    override suspend fun deleteTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun makeCompleteTask(id: String, value: Boolean) = withContext(Dispatchers.IO) {
        dao.makeCompleteTask(TaskMakeCompleteEntity(id = id, isCompleted = value))
    }

    private suspend fun getRemoteTasks(): List<Task> {
        return withContext(Dispatchers.IO) {
            val tasks = restInterface.getTasks()
            return@withContext ConvertTasks().fromRemote(tasks)
        }
    }

    private suspend fun getLocalTasks(): List<Task> {
        return withContext(Dispatchers.IO) {
            val tasks = dao.getAll()
            return@withContext ConvertTasks().fromLocal(tasks)
        }
    }

    private suspend fun insertTaskLocal(task: Task): Unit = withContext(Dispatchers.IO) {
        ConvertTask().toLocal(task)?.let { dao.insertTask(it) }
    }

    private suspend fun createTaskRemote(task: CreateTaskPayload): Unit = withContext(Dispatchers.IO)  {
        restInterface.createTask(task)
    }
}
