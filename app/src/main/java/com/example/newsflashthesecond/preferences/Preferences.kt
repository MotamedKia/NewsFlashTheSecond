package com.example.newsflashthesecond.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class ThemePreferences(private val context: Context) {
    private val Context.datastore by preferencesDataStore("settings")
    private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")

    suspend fun saveDarkThemeEnabled(enabled: Boolean) {
        context.datastore.edit { preferences ->
            preferences[DARK_THEME_KEY] = enabled
        }
    }

    suspend fun isDarkThemeEnabled(): Boolean {
        val preferences = context.datastore.data.first()
        return preferences[DARK_THEME_KEY] ?: false
    }
}

class AutoRefreshPreferences(private val context: Context) {
    private val Context.datastore by preferencesDataStore("Autorefresh")
    private val AUTO_REFRESH_KEY = booleanPreferencesKey("auto_refresh")

    suspend fun saveAutorefreshEnabled(enabled: Boolean) {
        context.datastore.edit { preferences ->
            preferences[AUTO_REFRESH_KEY] = enabled
        }
    }

    suspend fun isAutorefreshEnabled(): Boolean {
        val preferences = context.datastore.data.first()
        return preferences[AUTO_REFRESH_KEY] ?: false
    }
}

class LanguagePreferences(private val context: Context) {
    private val Context.datastore by preferencesDataStore("languages")
    private val ALIEN_LANGUAGE_KEY = booleanPreferencesKey("alien_language")

    suspend fun saveAlienLanguageEnabled(enabled: Boolean) {
        context.datastore.edit { preferences ->
            preferences[ALIEN_LANGUAGE_KEY] = enabled
        }
    }

    suspend fun isAlienLanguageEnabled(): Boolean {
        val preferences = context.datastore.data.first()
        return preferences[ALIEN_LANGUAGE_KEY] ?: false
    }
}
