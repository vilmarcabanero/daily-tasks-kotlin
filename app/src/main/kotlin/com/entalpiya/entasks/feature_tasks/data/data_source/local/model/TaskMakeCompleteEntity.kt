package com.entalpiya.entasks.feature_tasks.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskMakeCompleteEntity(
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "is_completed") val isCompleted: Boolean,
)
