package com.entalpiya.dailytasks.feature_auth.data.data_source.api

import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun loginRequest(@Body loginPayload: LoginPayload)
}