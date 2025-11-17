package com.example.booklist.providers

import com.example.booklist.data.api.GoogleBooksResponse
import kotlinx.coroutines.flow.Flow

interface RequestApiBooksProvider {
    suspend fun getApiBooks(): Flow<GoogleBooksResponse>
}