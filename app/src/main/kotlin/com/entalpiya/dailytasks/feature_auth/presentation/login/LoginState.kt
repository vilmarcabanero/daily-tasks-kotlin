package com.entalpiya.dailytasks.feature_auth.presentation.login

import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload

data class LoginState(
    val email: String = "",
    val password: String = "",
    val error: String? = null,
    val isSplashScreenLoading: Boolean = true,
)
