package com.example.newsflashthesecond.retrofit

suspend fun loadArticle(): List<NewsResponse> {
    return ApiClient.apiService.getTopHeadlines(apiKey = "cba177f159824c799d1d4f1df892a5d5")
}