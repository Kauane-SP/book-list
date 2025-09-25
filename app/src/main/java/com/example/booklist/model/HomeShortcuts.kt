package com.example.booklist.model

import com.example.booklist.R

enum class HomeShortcuts(val route: String, val label: String, val description: String) {
    LIST_BOOKS(
        R.string.home_shortcut_books.toString(),
        R.string.home_shortcut_books.toString(),
        R.string.home_shortcut_books.toString()
    ),
    FAVORITES(
        R.string.home_shortcuts_favorites.toString(),
        R.string.home_shortcuts_favorites.toString(),
        R.string.home_shortcuts_favorites.toString()
    )
}