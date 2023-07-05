package com.entalpiya.dailytasks.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.entalpiya.dailytasks.NavGraphs
import com.entalpiya.dailytasks.core.presentation.ui.theme.EnTasksTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnTasksTheme() {
                EnTasksApp()
            }
        }
    }

    @Composable
    private fun EnTasksApp() {
        DestinationsNavHost(navGraph = NavGraphs.root)
    }
}