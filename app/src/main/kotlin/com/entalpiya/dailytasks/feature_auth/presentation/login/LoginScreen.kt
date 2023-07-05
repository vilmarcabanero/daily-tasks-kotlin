package com.entalpiya.dailytasks.feature_auth.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.presentation.login.components.LoginInputsAndButton
import com.entalpiya.dailytasks.feature_auth.presentation.login.components.LoginInputsAndButtonProps

@Composable
fun LoginScreen(props: LoginScreenProps) {

    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            LoginInputsAndButton(
                modifier = Modifier,
                props = LoginInputsAndButtonProps(
                    props.state,
                    props.setEmail,
                    props.setPassword,
                    props.handleLogin,
                    props.navController,
                )
            )
        }
    }
}

data class LoginScreenProps(
    val state: State<LoginState>,
    val setEmail: (email: String) -> Unit,
    val setPassword: (password: String) -> Unit,
    val handleLogin: (loginPayload: LoginPayload) -> Unit,
    val navController: NavHostController,
)