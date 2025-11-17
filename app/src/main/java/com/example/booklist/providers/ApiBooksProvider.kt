package com.example.booklist.providers

import com.example.booklist.data.api.GoogleBooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiBooksProvider {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 10,
        @Query("filter") filter: String? = null,
        @Query("key") apiKey: String? = null
    ): GoogleBooksResponse
}