package com.example.newsflashthesecond.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.newsflashthesecond.preferences.LanguagePreferences
import com.example.newsflashthesecond.preferences.ThemePreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun Settings(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    isDarkTheme: Boolean,
    themePreferences: ThemePreferences,
    onThemeChange: (Boolean) -> Unit,
    languagePreferences: LanguagePreferences,
    isAlienLang: Boolean,
    onLangChange: (Boolean) -> Unit,
    customFont: FontFamily,
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 75.dp)
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text("Dark Theme", fontFamily = customFont)
            Spacer(modifier.width(50.dp))
            Switch(checked = isDarkTheme, onCheckedChange = { newValue ->
                onThemeChange(newValue)
                coroutineScope.launch {
                    themePreferences.saveDarkThemeEnabled(newValue)
                }
            })
        }
        HorizontalDivider()
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text("Alien Language", fontFamily = customFont)
            Spacer(modifier.width(50.dp))
            Switch(checked = isAlienLang, onCheckedChange = { newValue ->
                onLangChange(newValue)
                coroutineScope.launch {
                    languagePreferences.saveAlienLanguageEnabled(newValue)
                }
            })
        }
        HorizontalDivider()
    }
}