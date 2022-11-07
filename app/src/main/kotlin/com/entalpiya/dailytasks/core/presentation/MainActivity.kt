package com.entalpiya.dailytasks.core.presentation

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.entalpiya.dailytasks.R
import com.entalpiya.dailytasks.core.presentation.ui.theme.DailyTasksTheme
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListScreen
import com.entalpiya.dailytasks.feature_tasks.presentation.tasks_list.TasksListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            this.setKeepOnScreenCondition {
                mainViewModel.isLoading.value
            }
        }
        setContent {
            DailyTasksTheme() {
                DailyTasksApp()
            }
        }
    }
    @Composable
    private fun DailyTasksApp() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "tasks") {
            composable(route = "tasks") {
                val viewModel: TasksListViewModel = hiltViewModel()
                mainViewModel.setIsLoading(viewModel.state.value.isSplashScreenLoading)
                TasksListScreen(state = viewModel.state,
                    onTaskClick = { id, oldValue -> viewModel.makeCompleteTask(id, oldValue) },
                    setTaskTitle = { taskTitle -> viewModel.setTaskTitle(taskTitle) },
                    onInsertTask = { taskTitle -> viewModel.insertTask(taskTitle) }
                )
            }
        } //            composable(
            //                route = "restaurants/{restaurant_id}",
            //                arguments = listOf(navArgument("restaurant_id") { type = NavType.IntType }),
            //                deepLinks = listOf(navDeepLink { uriPattern = "www.eres.com/{restaurant_id}" })
            //            ) {
            //                val viewModel: RestaurantDetailsViewModel = hiltViewModel()
            //                RestaurantDetailsScreen(state = viewModel.state)
            //            }
    }
}