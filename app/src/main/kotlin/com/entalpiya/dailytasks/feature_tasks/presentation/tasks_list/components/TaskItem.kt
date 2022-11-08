package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.entalpiya.dailytasks.feature_tasks.domain.model.Task
import kotlin.random.Random

@Composable
fun TaskItem(task: Task, onTaskClick: (id: String, oldValue: Boolean) -> Unit) {
    var color: Color = when(task.category) {
        "EN" -> MaterialTheme.colors.primary
        "DD" -> Color(0xFF9B00FA)
        else -> Color(Random.nextInt(1, 255), Random.nextInt(1, 255), Random.nextInt(1, 255))
    }
    Box(modifier = Modifier.clickable { onTaskClick(task.id, !task.isCompleted) }) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)) {
            Icon(imageVector = Icons.Filled.Check, contentDescription = "Task", tint = color)
            Spacer(modifier = Modifier.weight(0.04f))
            Text(text = task.title, modifier = Modifier.weight(0.9f))
        }
    }
}
