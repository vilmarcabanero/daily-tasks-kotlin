package com.entalpiya.dailytasks.feature_tasks.data.data_source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.LocalTask
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskMakeCompleteEntity

@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks")
    suspend fun getAll(): List<LocalTask>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: LocalTask)

    @Delete
    suspend fun deleteTask(task: LocalTask)

    @Update(entity = LocalTask::class)
    suspend fun makeCompleteTask(taskMakeCompleteEntity: TaskMakeCompleteEntity)
}