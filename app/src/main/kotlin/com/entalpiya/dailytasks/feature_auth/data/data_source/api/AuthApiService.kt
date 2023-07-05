package com.entalpiya.dailytasks.feature_auth.data.data_source.api

import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.response.LoginResponse
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun loginRequest(@Body loginPayload: LoginPayload): LoginResponse

    @GET("auth/user")
    suspend fun getUserRequest(@Header("Authorization: Bearer ") authToken: String): UserResponse
}