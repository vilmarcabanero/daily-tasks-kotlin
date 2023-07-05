package com.entalpiya.dailytasks.feature_auth.domain.use_case

import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(loginPayload: LoginPayload) {
        repository.login(loginPayload)
    }
}
