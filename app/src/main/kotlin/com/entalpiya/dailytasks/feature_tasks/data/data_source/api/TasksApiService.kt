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

const val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGE0MDI5M2Y1OWEzNzhjYzhjMmE5OGYiLCJpYXQiOjE2ODg0NzAxNjQsImV4cCI6MTY4ODQ3Mzc2NH0.u11bjwZa3FFw4ZlMgzUvMv1bwpk1qhU9Twq3iq_SCFw"