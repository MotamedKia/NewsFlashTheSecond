package com.example.newsflashthesecond.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import com.example.newsflashthesecond.retrofit.Article

@Composable
fun HomeItem(
    modifier: Modifier = Modifier,
    customFont: FontFamily,
    article: Article,
) {
    Card(modifier.fillMaxWidth()){
        Row {

            Column {  }
        }
    }
}

//IMPORTANT: NOT COMPLETED