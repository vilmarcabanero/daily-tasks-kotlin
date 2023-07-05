package com.entalpiya.dailytasks.feature_auth.domain.repository

import android.content.Context
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.response.UserResponse

interface AuthRepository {
    suspend fun login(loginPayload: LoginPayload, context: Context)
    suspend fun getUser(context: Context): UserResponse
}