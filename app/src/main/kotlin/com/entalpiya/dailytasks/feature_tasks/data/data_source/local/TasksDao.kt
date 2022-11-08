package com.entalpiya.dailytasks.feature_tasks.data.data_source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskMakeCompleteEntity

@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks")
    suspend fun getAll(): List<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Update(entity = TaskEntity::class)
    suspend fun makeCompleteTask(taskMakeCompleteEntity: TaskMakeCompleteEntity)
}