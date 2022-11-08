package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task
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
            var taskTitleList: List<String> = emptyList()
            var category: String? = null
            val title: String
            if ("::" in taskTitle) {
                taskTitleList = taskTitle.split("::")
                category = taskTitleList[0]
                title = taskTitleList[1].trim()
            } else {
                title = taskTitle.trim()
            }

            var color: Long = when (category) {
                "EN" -> 0xFF0E9FFF
                "DD" -> 0xFF9B00FA
                else -> Random.nextLong()
            }

            if(title.isEmpty()) return@launch
            useCases.insertTask(Task(id = UUID.randomUUID().toString(),
                title = title,
                isCompleted = false,
                category = category,
                color = color))
            val tasks = useCases.getTasks()
            _state.value = _state.value.copy(tasks = tasks, taskTitle = "")
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch(errorHandler) {
            useCases.deleteTask(task)
            val tasks = useCases.getTasks()
            _state.value = _state.value.copy(tasks = tasks)
        }
    }
}