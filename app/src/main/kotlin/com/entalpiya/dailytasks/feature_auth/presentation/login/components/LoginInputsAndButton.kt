package com.entalpiya.dailytasks.feature_auth.presentation.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.entalpiya.dailytasks.destinations.TasksListScreenDestination
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.payload.LoginPayload
import com.entalpiya.dailytasks.feature_auth.presentation.login.LoginState
import com.entalpiya.dailytasks.feature_auth.presentation.login.LoginViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun LoginInputsAndButton(modifier: Modifier, props: LoginInputsAndButtonProps) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(3.dp)
                .padding(end = 6.dp)
        ) {
            TextField(
                value = props.vm.state.value.email,
                onValueChange = { props.vm.setEmail(it) },
                placeholder = { Text(text = "Email") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                ),
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = props.vm.state.value.password,
                onValueChange = { props.vm.setPassword(it) },
                placeholder = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    props.vm.handleLogin(
                        LoginPayload(
                            email = props.vm.state.value.email,
                            password = props.vm.state.value.password
                        ),
                        context
                    )
                    props.navigator.navigate(TasksListScreenDestination())
                }) {
                Text(text = if (props.vm.state.value.loginLoading == true) "Logging in..." else "Login")
            }
        }
    }
}

data class LoginInputsAndButtonProps(
    val vm: LoginViewModel,
    val navigator: DestinationsNavigator
)