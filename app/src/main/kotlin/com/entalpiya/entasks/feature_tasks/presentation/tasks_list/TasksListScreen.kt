package com.entalpiya.entasks.feature_tasks.presentation.tasks_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.entalpiya.entasks.feature_tasks.presentation.tasks_list.components.TaskItem
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TasksListScreen(
    state: State<TasksListState>,
    onTaskClick: (id: String, oldValue: Boolean) -> Unit,
    setTaskTitle: (taskTitle: String) -> Unit,
    onInsertTask: (taskTitle: String) -> Unit,
) {
    Surface() {
        Column() {
            val calendar = Calendar.getInstance()
            val simpleDateFormat = SimpleDateFormat("EEEE, d LLLL")
            val dateTime = simpleDateFormat.format(calendar.time).toString()
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth()) {
                Text(text = dateTime)
            }
            Box(contentAlignment = Alignment.TopStart, modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)) {
                LazyColumn {
                    items(state.value.tasks) {
                        TaskItem(it) { id, oldValue ->
                            onTaskClick(id, oldValue)
                        }
                    }
                }
                state.value.error?.let { Text(it) }
            }
            Row(modifier = Modifier
                .height(50.dp)
                .weight(0.07f)
                .padding(3.dp)
                .padding(end = 6.dp)) {
                BasicTextField(value = state.value.taskTitle,
                    onValueChange = { setTaskTitle(it) },
                    decorationBox = {
                        Box(Modifier.padding(12.dp)) {
                            if (state.value.taskTitle.isEmpty()) {
                                Text("New task", style = TextStyle(fontSize = 16.sp, color = Color(0xFF8d8d8d)))
                            }
                            it()
                        }
                    },
                    modifier = Modifier.weight(1f),
                    textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onBackground),
                    cursorBrush = SolidColor(MaterialTheme.colors.primary))
                IconButton(onClick = { onInsertTask(state.value.taskTitle) }, ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add", tint = MaterialTheme.colors.primary)
                }
            }
        }
    }
}