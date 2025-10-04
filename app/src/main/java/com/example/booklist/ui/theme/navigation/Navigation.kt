package com.example.booklist.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.booklist.model.HomeShortcuts
import com.example.booklist.ui.theme.screens.DashListBooks
import com.example.booklist.ui.theme.screens.DashListFavorites

@Composable
fun NavigationGraph(
    navController: NavHostController, homeShortcuts: HomeShortcuts
) {
    NavHost(navController = navController, startDestination = homeShortcuts.route) {
        HomeShortcuts.entries.forEach { destination ->
            composable(destination.route) {
                when(destination) {
                    HomeShortcuts.LIST_BOOKS -> DashListBooks()
                    HomeShortcuts.FAVORITES -> DashListFavorites()
                }
            }
        }
    }
}