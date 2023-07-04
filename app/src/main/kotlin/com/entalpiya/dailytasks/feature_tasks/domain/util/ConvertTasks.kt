package com.entalpiya.dailytasks.feature_tasks.domain.util

import com.entalpiya.dailytasks.feature_tasks.data.data_source.api.RemoteTask
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.LocalTask
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task

class ConvertTasks {
    fun fromLocal(localTasks: List<LocalTask>): List<Task> {
        return localTasks.map { ConvertTask().fromLocal(it)}
    }

    fun fromRemote(remoteTasks: List<RemoteTask>): List<Task> {
        return remoteTasks.map { ConvertTask().fromRemote(it) }
    }

    fun toLocal(tasks: List<Task>): List<LocalTask?> {
        return tasks.map { ConvertTask().toLocal(it) }
    }

    fun toRemote(tasks: List<Task>): List<LocalTask?> {
        return tasks.map { ConvertTask().toRemote(it) }
    }
}