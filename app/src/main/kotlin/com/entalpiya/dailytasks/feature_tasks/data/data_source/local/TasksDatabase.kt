package com.entalpiya.dailytasks.feature_tasks.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 2,
    exportSchema = false
)
abstract class TasksDatabase : RoomDatabase() {
    abstract val dao: TasksDao

    companion object {
        const val DATABASE_NAME = "tasks_db"
    }
}