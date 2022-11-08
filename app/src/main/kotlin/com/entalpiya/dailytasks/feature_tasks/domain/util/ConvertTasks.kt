package com.entalpiya.dailytasks.feature_tasks.domain.util

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task

class ConvertTasks {
    fun fromLocal(localTasks: List<TaskEntity>): List<Task> {
        return localTasks.map { ConvertTask().fromLocal(it)}
    }

    fun fromRemote(remoteTasks: List<TaskEntity>): List<Task> {
        return remoteTasks.map { ConvertTask().fromRemote(it) }
    }

    fun toLocal(tasks: List<Task>): List<TaskEntity> {
        return tasks.map { ConvertTask().toLocal(it) }
    }

    fun toRemote(tasks: List<Task>): List<TaskEntity> {
        return tasks.map { ConvertTask().toRemote(it) }
    }
}