package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.booklist.ui.theme.viewModel.BooksViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashListBooks(navHostController: NavHostController, viewModel: BooksViewModel = koinViewModel()) {
    LaunchedEffect(Unit) { viewModel.initVieModel() }
    val listBooks = viewModel.stateValueBook.collectAsState().value

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        LazyColumn(Modifier.weight(1f)) {
            items(listBooks) {
                ListItemDash(navHostController, it)
            }
        }
    }
}