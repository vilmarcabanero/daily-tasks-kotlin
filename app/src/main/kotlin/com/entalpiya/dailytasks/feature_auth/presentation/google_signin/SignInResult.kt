package com.entalpiya.dailytasks.feature_auth.presentation.google_signin

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val username: String?,
    val email: String?,
    val profilePictureUrl: String?
)
