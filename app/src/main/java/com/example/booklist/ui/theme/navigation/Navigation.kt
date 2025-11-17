package com.example.booklist.ui.theme.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.booklist.R
import com.example.booklist.model.BooksModel
import com.example.booklist.model.HomeShortcuts
import com.example.booklist.ui.theme.screens.DashListBooks
import com.example.booklist.ui.theme.screens.AddBooks
import com.example.booklist.ui.theme.screens.HomeTabRow
import com.example.booklist.ui.theme.screens.ItemBook
import com.example.booklist.ui.theme.screens.UserLogin
import com.example.booklist.ui.theme.screens.UserRegister

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun NavigationGraph(
    navController: NavHostController, paddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = R.string.route_login.toString()) {
        composable(R.string.route_register.toString()) {
            UserRegister(paddingValues, navController)
        }
        composable(R.string.route_home.toString()) {
            HomeTabRow(paddingValues)
        }
        composable(R.string.route_login.toString()) {
            UserLogin(paddingValues, navController)
        }
    }
}


@Composable
fun NavigationGraphTabRow(navController: NavHostController, homeShortcuts: HomeShortcuts) {
    NavHost(navController, startDestination = homeShortcuts.route) {
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