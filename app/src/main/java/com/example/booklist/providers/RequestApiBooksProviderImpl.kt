package com.example.booklist.providers

import com.example.booklist.data.api.GoogleBooksResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RequestApiBooksProviderImpl(private val service: ApiBooksProvider) : RequestApiBooksProvider {
    override suspend fun getApiBooks(): Flow<GoogleBooksResponse> {
        return flow {
            emit(
                service.searchBooks(
                    "adventure",
                    10,
                    "free-ebooks",
                    "AIzaSyDliGqWMejt8BY4KZAQociVUNIOXn2gvR4"
                )
            )
        }
    }
}