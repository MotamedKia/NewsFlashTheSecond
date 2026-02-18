package com.example.newsflashthesecond.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import com.example.newsflashthesecond.retrofit.Article

@Composable
fun FullItem(
    modifier: Modifier = Modifier,
    customFont: FontFamily,
    article: Article,
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(article.title ?: "No title", fontFamily = customFont)
    }
}