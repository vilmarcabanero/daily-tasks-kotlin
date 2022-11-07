package com.entalpiya.entasks.feature_tasks.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.entalpiya.entasks.feature_tasks.data.data_source.local.model.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 3,
    exportSchema = false
)
abstract class TasksDatabase : RoomDatabase() {
    abstract val dao: TasksDao

    companion object {
        const val DATABASE_NAME = "en_tasks_db"
    }
}