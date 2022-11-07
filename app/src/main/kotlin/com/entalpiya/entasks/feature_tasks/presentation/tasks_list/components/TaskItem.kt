package com.entalpiya.entasks.feature_tasks.presentation.tasks_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.entalpiya.entasks.feature_tasks.data.data_source.local.model.TaskEntity

@Composable
fun TaskItem(task: TaskEntity, onTaskClick: (id: String, oldValue: Boolean) -> Unit) {
    Box(modifier = Modifier
        .clickable { onTaskClick(task.id, !task.isCompleted) }) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(14.dp)) {
            Text(text = task.title, modifier = Modifier.weight(1f))
        }
    }
}