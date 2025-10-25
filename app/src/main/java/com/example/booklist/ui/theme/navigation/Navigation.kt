package com.example.booklist.ui.theme.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.booklist.model.BooksModel
import com.example.booklist.model.HomeShortcuts
import com.example.booklist.ui.theme.screens.DashListBooks
import com.example.booklist.ui.theme.screens.AddBooks
import com.example.booklist.ui.theme.screens.ItemBook

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun NavigationGraph(
    navController: NavHostController, homeShortcuts: HomeShortcuts
) {
    NavHost(navController = navController, startDestination = homeShortcuts.route) {
        HomeShortcuts.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    HomeShortcuts.LIST_BOOKS -> DashListBooks(navController)
                    HomeShortcuts.FAVORITES -> AddBooks()
                }
            }
        }
        composable<BooksModel> { it ->
            val books: BooksModel = it.toRoute()
            ItemBook(books, navController)
        }
    }
}