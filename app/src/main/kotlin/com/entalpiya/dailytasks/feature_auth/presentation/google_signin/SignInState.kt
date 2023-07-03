package com.entalpiya.dailytasks.feature_auth.presentation.google_signin

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
    val isSplashScreenLoading: Boolean = true,
)
