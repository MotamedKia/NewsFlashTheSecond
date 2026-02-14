package com.example.newsflashthesecond

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.newsflashthesecond.preferences.LanguagePreferences
import com.example.newsflashthesecond.preferences.ThemePreferences
import com.example.newsflashthesecond.screens.Home
import com.example.newsflashthesecond.screens.Settings
import com.example.newsflashthesecond.ui.theme.NewsFlashTheSecondTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private enum class Screen {
    HOME,
    SETTINGS
}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            var currentScreen by remember { mutableStateOf(Screen.HOME) }
            var currentTitle by remember { mutableStateOf("News Flash Jr") }
            when (currentScreen) {
                Screen.SETTINGS -> currentTitle = "Settings"
                Screen.HOME -> currentTitle = "Home"
            }

            val coroutineScope = rememberCoroutineScope()
            val themePreferences = remember { ThemePreferences(applicationContext) }
            val languagePreferences = remember { LanguagePreferences(applicationContext) }

            var isDarkTheme by remember { mutableStateOf(false) }
            var isAlienLang by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                isDarkTheme = themePreferences.isDarkThemeEnabled()
                isAlienLang = languagePreferences.isAlienLanguageEnabled()
            }

            NewsFlashTheSecondTheme(darkTheme = isDarkTheme) {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(title = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        currentTitle,
                                        fontFamily = if (isAlienLang) FontFamily(Font(R.font.allymade)) else FontFamily.Default
                                    )
                                }
                            }
                        }
                    })
                }) { innerPadding ->
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(end = 20.dp, top = 100.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.End
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        ) {
                            Column {
                                IconButton(onClick = { currentScreen = Screen.HOME }) {
                                    Icon(Icons.Default.Home, "Home")
                                }
                                IconButton(onClick = { currentScreen = Screen.SETTINGS }) {
                                    Icon(Icons.Default.Settings, "Settings")
                                }
                            }
                        }
                    }
                    when (currentScreen) {
                        Screen.SETTINGS -> Settings(
                            Modifier.padding(innerPadding),
                            coroutineScope,
                            isDarkTheme,
                            themePreferences,
                            { isDarkTheme = it },
                            languagePreferences,
                            isAlienLang,
                            { isAlienLang = it },
                            if (isAlienLang) FontFamily(Font(R.font.allymade)) else FontFamily.Default
                        )

                        Screen.HOME -> Home(modifier = Modifier.padding(innerPadding))
                    }

                }
            }
        }
    }
}