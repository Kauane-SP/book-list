package com.example.booklist.ui.theme.viewModel

sealed class BookEvents {
    object Success: BookEvents()
    data class Error(val message: String) : BookEvents()
}