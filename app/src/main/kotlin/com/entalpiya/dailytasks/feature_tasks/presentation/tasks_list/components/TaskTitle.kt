package com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TaskTitle() {
    val calendar = Calendar.getInstance()
    val simpleDateFormat = SimpleDateFormat("EEEE, d LLLL")
    val dateTime = simpleDateFormat.format(calendar.time).toString()
    Row(horizontalArrangement = Arrangement.End, modifier = Modifier
        .padding(14.dp)
        .fillMaxWidth()) {
        Text(text = dateTime)
    }
}