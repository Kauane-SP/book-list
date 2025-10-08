package com.example.booklist.providers

import com.example.booklist.model.BooksModel

interface StorageServiceProvider {
    suspend fun getListBooks(): List<BooksModel>

    suspend fun getBook(idBook: String): BooksModel?

    suspend fun saveBooks(booksModel: BooksModel)

    suspend fun updateBooks(booksModel: BooksModel)

    suspend fun deleteBooks(idBook: String)
}