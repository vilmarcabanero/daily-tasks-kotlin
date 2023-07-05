package com.entalpiya.dailytasks.feature_auth.data.data_source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreAuthToken(private val context: Context) {
    /* to make sure there is only one instance */
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("AuthToken")
        val AUTH_TOKEN_KEY = stringPreferencesKey("auth_token")
    }

    val getAuthToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[AUTH_TOKEN_KEY] ?: ""
        }

    suspend fun setAuthToken(value: String) {
        context.dataStore.edit { preferences ->
            preferences[AUTH_TOKEN_KEY] = value
        }
    }
}

//const val USER_PREFERENCES_NAME = "auth_preferences"
//
//private val Context.dataStore by preferencesDataStore(
//    name = USER_PREFERENCES_NAME
//)
//
//private object PreferencesKeys {
//    val AUTH_TOKEN = stringPreferencesKey("auth_token")
//}
//
