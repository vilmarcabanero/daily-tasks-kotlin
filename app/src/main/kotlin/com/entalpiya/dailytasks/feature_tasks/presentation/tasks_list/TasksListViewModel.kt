package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.entalpiya.dailytasks.core.presentation.MainViewModel
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskEntity
import com.entalpiya.dailytasks.feature_tasks.data.data_source.local.model.TaskMakeCompleteEntity
import com.entalpiya.dailytasks.feature_tasks.domain.use_case.TasksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class TasksListViewModel @Inject constructor(private val useCases: TasksUseCases) : ViewModel() {
    private val _state = mutableStateOf(TasksListState())
    val state: State<TasksListState> = _state

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _state.value = _state.value.copy(error = exception.message)
    }

    init {
        getTasks()
        _state.value = _state.value.copy(isSplashScreenLoading = false)
    }

    private fun getTasks() {
        viewModelScope.launch(errorHandler) {
            val tasks = useCases.getTasks()
            _state.value = _state.value.copy(tasks = tasks)
        }
    }

    fun makeCompleteTask(id: String, value: Boolean) {
        viewModelScope.launch(errorHandler) {
            useCases.makeComplete(id = id, value = value)
            val tasks = useCases.getTasks()
            _state.value = _state.value.copy(tasks = tasks)
        }
    }

    fun setTaskTitle(taskTitle: String) {
        _state.value = _state.value.copy(taskTitle = taskTitle)
    }

    fun insertTask(taskTitle: String) {
        viewModelScope.launch(errorHandler) {
            useCases.insertTask(TaskEntity(id = UUID.randomUUID().toString(), title = taskTitle, isCompleted = false))
            val tasks = useCases.getTasks()
            _state.value = _state.value.copy(tasks = tasks, taskTitle = "")
        }
    }

    fun deleteTask(taskEntity: TaskEntity) {
        viewModelScope.launch(errorHandler) {
            useCases.deleteTask(taskEntity)
            val tasks = useCases.getTasks()
            _state.value = _state.value.copy(tasks = tasks)
        }
    }
}