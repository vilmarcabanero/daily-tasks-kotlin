package com.entalpiya.dailytasks.feature_auth.presentation.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.AuthApiService
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginViewModel : ViewModel() {
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

    fun handleLogin(loginPayload: LoginPayload) {
//        viewModelScope.launch(errorHandler) {
//            repository.login(loginPayload)
//        }
        // Sobrang hirap, di ko kaya hahahaha Next.js nalang muna.
    }
}