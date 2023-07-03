package com.entalpiya.dailytasks.feature_tasks.domain.use_case

data class TasksUseCases (
    val getTasks: GetTasks,
    val insertTask: InsertTask,
    val deleteTask: DeleteTask,
    val makeComplete: MakeComplete,
)
