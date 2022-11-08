package com.entalpiya.dailytasks.feature_tasks.domain.util

import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task

class ConvertTask {
    fun fromLocal(task: TaskEntity): Task {
        return Task(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }

    fun fromRemote(task: TaskEntity): Task {
        return Task(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }

    fun toLocal(task: Task): TaskEntity {
        return TaskEntity(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }

    fun toRemote(task: Task): TaskEntity {
        return TaskEntity(id = task.id, title = task.title, isCompleted = task.isCompleted, category = task.category)
    }
}