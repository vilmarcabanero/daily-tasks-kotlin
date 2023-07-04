package com.entalpiya.dailytasks.feature_tasks.data.data_source.api

import com.entalpiya.dailytasks.feature_tasks.data.data_source.api.payload.CreateTaskPayload
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface TasksApiService {
    @GET("tasks")
    suspend fun getTasks(): List<RemoteTask>

    @POST("tasks")
    @Headers("Authorization: Bearer $token")
    suspend fun createTask(@Body task: CreateTaskPayload)
}