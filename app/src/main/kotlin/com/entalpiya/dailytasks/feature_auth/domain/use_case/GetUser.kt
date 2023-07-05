package com.entalpiya.dailytasks.feature_auth.domain.use_case

import android.content.Context
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.response.UserResponse
import com.entalpiya.dailytasks.feature_auth.domain.repository.AuthRepository
import javax.inject.Inject

class GetUser @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(context: Context): UserResponse {
        return repository.getUser(context)
    }
}