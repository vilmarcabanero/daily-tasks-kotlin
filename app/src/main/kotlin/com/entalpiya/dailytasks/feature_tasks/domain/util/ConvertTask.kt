package com.entalpiya.dailytasks.feature_tasks.domain.util

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.LocalTask
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task

class ConvertTask {
    fun fromLocal(task: LocalTask): Task {
        return Task(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }

    fun fromRemote(task: LocalTask): Task {
        return Task(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }

    fun toLocal(task: Task): LocalTask {
        return LocalTask(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }

    fun toRemote(task: Task): LocalTask {
        return LocalTask(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }
}
