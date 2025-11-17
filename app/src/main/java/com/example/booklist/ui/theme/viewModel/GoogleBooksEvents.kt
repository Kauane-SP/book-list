package com.example.booklist.ui.theme.viewModel

import com.example.booklist.data.api.GoogleBooksResponse

sealed class GoogleBooksEvents {
    object LoadBooks: GoogleBooksEvents()
    data class GetGoogleBooks(val books: GoogleBooksResponse): GoogleBooksEvents()
}