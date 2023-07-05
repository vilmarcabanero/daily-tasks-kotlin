package com.entalpiya.dailytasks.feature_auth.presentation.login

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavigatorProvider
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.domain.use_case.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val useCases: AuthUseCases) : ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _state.value = _state.value.copy(error = exception.message)
    }

    init {
        _state.value = _state.value.copy(isSplashScreenLoading = false)
    }

    fun setEmail(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun setPassword(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun handleLogin(loginPayload: LoginPayload, context: Context) {
        viewModelScope.launch(errorHandler) {
            _state.value = _state.value.copy(loginLoading = true)
            useCases.login(loginPayload, context)
            _state.value = _state.value.copy(loginLoading = false)
        }
    }

}