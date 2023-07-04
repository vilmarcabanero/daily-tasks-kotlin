package com.entalpiya.dailytasks.feature_tasks.data.data_source.api

import com.google.gson.annotations.SerializedName

data class RemoteTask(
    @SerializedName("_id") val id: String,
    @SerializedName("task") val title: String,
    @SerializedName("complete") val isCompleted: Boolean
)