package com.entalpiya.dailytasks.feature_auth.presentation.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.presentation.login.LoginState

@Composable
fun LoginInputsAndButton(modifier: Modifier, props: LoginInputsAndButtonProps) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(3.dp)
                .padding(end = 6.dp)
        ) {
            TextField(
                value = props.state.value.email,
                onValueChange = { props.setEmail(it) },
                placeholder = { Text(text = "Email") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                ),
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = props.state.value.password,
                onValueChange = { props.setPassword(it) },
                placeholder = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    props.handleLogin(
                        LoginPayload(
                            email = props.state.value.email,
                            password = props.state.value.password
                        )
                    )
                }) {
                Text(text = "Login")
            }
        }
    }
}

data class LoginInputsAndButtonProps(
    val state: State<LoginState>,
    val setEmail: (email: String) -> Unit,
    val setPassword: (password: String) -> Unit,
    val handleLogin: (loginPayload: LoginPayload) -> Unit,
)