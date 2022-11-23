package com.entalpiya.dailytasks

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DailyTasksApplication: Application()

/*
*   DONE: Can group the tasks. EN: First task for Entalpiya. ACN: Finish DD-2093
*   // Output would be First task for Entalpiya but can be grouped with other EN: tasks. Should have divider
*   TODO: Clear focus after adding new task or after clicking outside the text field.
*   DONE: Add validation
*   TODO: Create a list of long for colors (dark colors for light mode, light colors for dark mode)
*
*/