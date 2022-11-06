package com.entalpiya.dailytasks.feature_tasks.di

import android.content.Context
import androidx.room.Room
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.TasksDao
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.TasksDatabase
import com.entalpiya.dailytasks.feature_tasks.data.repository.TasksRepositoryImpl
import com.entalpiya.dailytasks.feature_tasks.domain.repository.TasksRepository
import com.entalpiya.dailytasks.feature_tasks.domain.use_case.DeleteTask
import com.entalpiya.dailytasks.feature_tasks.domain.use_case.GetTasks
import com.entalpiya.dailytasks.feature_tasks.domain.use_case.InsertTask
import com.entalpiya.dailytasks.feature_tasks.domain.use_case.MakeComplete
import com.entalpiya.dailytasks.feature_tasks.domain.use_case.TasksUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TasksModule {
    @Provides
    fun provideRoomDao(database: TasksDatabase): TasksDao {
        return database.dao
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext appContext: Context,
    ): TasksDatabase {
        return Room.databaseBuilder(appContext, TasksDatabase::class.java, TasksDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTasksRepository(db: TasksDatabase): TasksRepository {
        return TasksRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideTasksUseCases(repository: TasksRepository): TasksUseCases {
        return TasksUseCases(
            getTasks = GetTasks(repository),
            insertTask = InsertTask(repository),
            deleteTask = DeleteTask(repository),
            makeComplete = MakeComplete(repository)
        )
    }
}