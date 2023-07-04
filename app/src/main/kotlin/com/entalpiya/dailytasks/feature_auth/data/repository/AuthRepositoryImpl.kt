package com.entalpiya.dailytasks.feature_auth.data.repository

import com.entalpiya.dailytasks.feature_auth.data.data_source.api.AuthApiService
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor (
    private val restInterface: AuthApiService,
) {
    suspend fun login(loginPayload: LoginPayload): Unit = withContext(Dispatchers.IO) {
        restInterface.loginRequest(loginPayload)
    }
}