package com.example.booklist.ui.theme.viewModel

sealed class BookEvents {
    data object Success: BookEvents()
    data class Error(val message: String) : BookEvents()
}