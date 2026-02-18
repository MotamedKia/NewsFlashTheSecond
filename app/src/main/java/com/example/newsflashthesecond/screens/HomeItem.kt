package com.example.newsflashthesecond.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsflashthesecond.retrofit.Article

@Composable
fun HomeItem(
    modifier: Modifier = Modifier,
    customFont: FontFamily,
    article: Article,
    onClick: (Article) -> Unit,
) {
    if (article.title.isNullOrBlank()) return
    Card(
        modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = { onClick(article) }),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            if (!article.urlToImage.isNullOrEmpty()) {
                AsyncImage(
                    model = article.urlToImage,
                    contentDescription = article.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }

            Spacer(Modifier.height(8.dp))
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    article.title ?: "NO TITLE",
                    fontFamily = customFont,
                    style = MaterialTheme.typography.titleLarge/*,
                    maxLines = 2*/
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "👤${article.author ?: " "} 📝${article.publishedAt ?: " "} 🌐${article.source?.name ?: " "}",
                    fontFamily = customFont,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(12.dp))
            }
        }
    }
}