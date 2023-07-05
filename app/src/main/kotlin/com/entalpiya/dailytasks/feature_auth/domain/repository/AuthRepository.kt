package com.entalpiya.dailytasks.feature_auth.domain.repository

import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload

interface AuthRepository {
    suspend fun login(loginPayload: LoginPayload)
}