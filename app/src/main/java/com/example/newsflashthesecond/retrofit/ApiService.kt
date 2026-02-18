package com.example.newsflashthesecond.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Top headlines (country-based)
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("pageSize") pageSize: Int = 20,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String,
    ): NewsResponse


    // Search everything endpoint
    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("pageSize") pageSize: Int = 20,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String,
    ): NewsResponse
}