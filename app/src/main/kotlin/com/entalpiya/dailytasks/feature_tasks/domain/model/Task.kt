package com.entalpiya.dailytasks.feature_tasks.domain.model

import androidx.compose.ui.graphics.Color

data class Task(
    val id: String,
    val title: String,
    val isCompleted: Boolean,
    val category: String?,
)