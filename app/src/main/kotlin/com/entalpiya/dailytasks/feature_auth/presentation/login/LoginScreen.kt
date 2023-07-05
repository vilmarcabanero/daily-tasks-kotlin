package com.entalpiya.dailytasks.feature_auth.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.entalpiya.dailytasks.feature_auth.presentation.login.components.LoginInputsAndButton
import com.entalpiya.dailytasks.feature_auth.presentation.login.components.LoginInputsAndButtonProps
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination(start = true)
@Composable
fun LoginScreen(navigator: DestinationsNavigator, vm: LoginViewModel = hiltViewModel()) {
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
                    vm,
                    navigator,
                )
            )
        }
    }
}
