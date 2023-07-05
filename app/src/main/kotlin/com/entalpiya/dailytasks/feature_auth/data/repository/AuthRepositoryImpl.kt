package com.entalpiya.dailytasks.feature_auth.data.repository

import android.content.Context
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.AuthApiService
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.data.data_source.local.StoreAuthToken
import com.entalpiya.dailytasks.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor (
    private val restInterface: AuthApiService,
): AuthRepository {
    override suspend fun login(loginPayload: LoginPayload, context: Context) = withContext(Dispatchers.IO) {
        val dataStore = StoreAuthToken(context)
        val loginResponse = restInterface.loginRequest(loginPayload)
        dataStore.setAuthToken(loginResponse.accessToken)
    }

    override suspend fun getUser(context: Context) = withContext(Dispatchers.IO) {
        val dataStore = StoreAuthToken(context)
        val authToken = dataStore.getAuthToken.first() ?: ""
        val user = restInterface.getUserRequest(authToken)
        println(">>firstName: ${user.firstName}")
        return@withContext user
    }
}