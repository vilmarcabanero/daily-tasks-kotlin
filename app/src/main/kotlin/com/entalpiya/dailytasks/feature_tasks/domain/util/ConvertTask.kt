package com.entalpiya.dailytasks.feature_tasks.domain.util

import com.entalpiya.dailytasks.feature_tasks.data.data_source.api.RemoteTask
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.LocalTask
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task

class ConvertTask {
    fun fromLocal(task: LocalTask): Task {
        return Task(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category, color = task.color)
    }

    fun fromRemote(task: RemoteTask): Task {
        return Task(id = task.id, title = task.title, isCompleted = task.isCompleted, category = null, color = null)
    }

    fun toLocal(task: Task): LocalTask? {
        return task.color?.let { LocalTask(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category, color = it) }
    }

    fun toRemote(task: Task): LocalTask? {
        return task.color?.let { LocalTask(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category, color = it) }
    }
}
