package com.example.newsflashthesecond.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsflashthesecond.retrofit.Article

@Composable
fun FullItem(
    modifier: Modifier = Modifier,
    customFont: FontFamily,
    article: Article,
    onShareClick: () -> Unit,
    onSaveClick: () -> Unit,
    onBackClick:()-> Unit
) {
Column(Modifier.fillMaxSize().padding(top = 20.dp),verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
    CircleIconButton(
        icon = Icons.Default.KeyboardArrowLeft,
        onClick = onBackClick
    )
}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // TITLE
        Text(
            text = article.title ?: "WHAAAT???",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp),
            fontFamily = customFont
        )

        // IMAGE (Async)
        AsyncImage(
            model = article.urlToImage,
            contentDescription = article.title ?: "THE TITLE",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // AUTHOR
        Text(
            text = "👤${article.author ?: " "}\n📝${article.publishedAt ?: " "}\n🌐${article.source?.name ?: " "}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth(),
            fontFamily = customFont,
            textAlign = TextAlign.Start
        )

        // DESCRIPTION CARD (ONE TEXT COMPONENT)
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            )
        ) {
            Text(
                text = article.content ?: "WHAT ARTICLE DID YOU ACTUALLY OPEN!?",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                lineHeight = 26.sp,
                modifier = Modifier.padding(20.dp),
                fontFamily = customFont
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // BOTTOM BUTTONS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.Start
        ) {

            CircleIconButton(
                icon = Icons.Default.Share,
                onClick = onShareClick
            )

            Spacer(modifier = Modifier.width(12.dp))

            CircleIconButton(
                icon = Icons.Default.FavoriteBorder,
                onClick = onSaveClick
            )
        }
    }
}

@Composable
fun CircleIconButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
    }
}