package com.example.booklist.model

import com.example.booklist.R

enum class HomeShortcuts(val route: String, val label: String, val description: String) {
    LIST_BOOKS(
        R.string.home_shortcut_books.toString(),
        R.string.home_shortcut_books.toString(),
        R.string.home_shortcut_books.toString()
    ),
    FAVORITES(
        R.string.home_shortcuts_add_books.toString(),
        R.string.home_shortcuts_add_books.toString(),
        R.string.home_shortcuts_add_books.toString()
    )
}