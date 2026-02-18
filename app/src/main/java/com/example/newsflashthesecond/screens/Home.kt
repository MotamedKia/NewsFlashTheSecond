package com.example.newsflashthesecond.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.newsflashthesecond.retrofit.Article
import com.example.newsflashthesecond.retrofit.NewsResponse

@Composable
fun Home(
    modifier: Modifier = Modifier,
    customFont: FontFamily,
    isloading: Boolean,
    errorMessage: String? = null,
    newsResponse: List<Article>,
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isloading) {
            CircularProgressIndicator()
            Spacer(modifier.height(16.dp))
            errorMessage?.let {
                Text("Error: $it", color = MaterialTheme.colorScheme.error)
                Spacer(modifier.height(12.dp))
            }
        } else {
            LazyColumn {
                items(newsResponse) { article ->
                    Text(article.title ?: "No title", fontFamily = customFont)
                    Spacer(modifier = Modifier.height(18.dp))
                    HorizontalDivider()
                }
            }
        }
    }
}
