package com.entalpiya.dailytasks

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DailyTasksApplication: Application()

/*
* TODO: Can group the tasks. EN: First task for Entalpiya. ACN: Finish DD-2093
* // Output would be First task for Entalpiya but can be grouped with other EN: tasks. Should have divider
*/