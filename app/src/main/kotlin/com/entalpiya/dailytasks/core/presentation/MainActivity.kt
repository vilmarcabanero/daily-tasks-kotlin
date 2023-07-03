package com.entalpiya.dailytasks.core.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.entalpiya.dailytasks.core.presentation.ui.theme.enTasksTheme
import com.entalpiya.dailytasks.feature_auth.presentation.google_signin.GoogleAuthUiClient
import com.entalpiya.dailytasks.feature_auth.presentation.google_signin.SignInScreen
import com.entalpiya.dailytasks.feature_auth.presentation.google_signin.SignInViewModel
import com.entalpiya.dailytasks.feature_auth.presentation.profile.ProfileScreen
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListScreen
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListViewModel
import com.google.android.gms.auth.api.identity.Identity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            this.setKeepOnScreenCondition {
                mainViewModel.isLoading.value
            }
        }
        setContent {
            enTasksTheme() {
                enTasksApp()
            }
        }
    }

    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    private fun enTasksApp() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "sign_in") {
            composable("tasks") {
                val viewModel: TasksListViewModel = hiltViewModel()
                mainViewModel.setIsLoading(viewModel.state.value.isSplashScreenLoading)
                TasksListScreen(state = viewModel.state,
                    onTaskClick = { id, oldValue -> viewModel.makeCompleteTask(id, oldValue) },
                    setTaskTitle = { taskTitle -> viewModel.setTaskTitle(taskTitle) },
                    onInsertTask = { taskTitle -> viewModel.insertTask(taskTitle) }
                )
            }
            composable("sign_in") {
                val viewModel = viewModel<SignInViewModel>()
                val state = viewModel.state.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = Unit) {
                    if (googleAuthUiClient.getSignedInUser() != null) {
                        navController.navigate("profile")
                    }
                }

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        if (result.resultCode == RESULT_OK) {
                            lifecycleScope.launch {
                                val signInResult = googleAuthUiClient.signInWithIntent(
                                    intent = result.data ?: return@launch
                                )
                                viewModel.onSignInResult(signInResult)
                            }
                        }
                    }
                )

                LaunchedEffect(key1 = state.value.isSignInSuccessful) {
                    if (state.value.isSignInSuccessful) {
                        Toast.makeText(applicationContext, "Sign in successful", Toast.LENGTH_LONG)
                            .show()

                        navController.navigate("profile")
                        viewModel.resetState()
                    }
                }

                mainViewModel.setIsLoading(state.value.isSplashScreenLoading)
                SignInScreen(
                    state = viewModel.state,
                    onSignInClick = {
                        lifecycleScope.launch {
                            val signInIntentSender = googleAuthUiClient.signIn()
                            launcher.launch(
                                IntentSenderRequest.Builder(
                                    signInIntentSender ?: return@launch
                                ).build()
                            )
                        }
                    })
            }
            composable("profile") {
                ProfileScreen(userData = googleAuthUiClient.getSignedInUser(), onSignOut = {
                    lifecycleScope.launch {
                        googleAuthUiClient.signOut()
                        Toast.makeText(applicationContext, "Signed out", Toast.LENGTH_LONG).show()
                        navController.navigate("sign_in")
                    }
                })
            }

        }
    }
}