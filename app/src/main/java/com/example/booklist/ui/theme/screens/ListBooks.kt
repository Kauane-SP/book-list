package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.booklist.R
import com.example.booklist.ui.theme.textStyleTitleAlert
import com.example.booklist.ui.theme.viewModel.BooksViewModel
import com.example.booklist.ui.theme.viewModel.GoogleBooksEvents
import com.example.booklist.ui.theme.viewModel.GoogleBooksViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashListBooks(
    navHostController: NavHostController,
    viewModel: BooksViewModel = koinViewModel(),
    viewModelGoogleBooks: GoogleBooksViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.initVieModel()
        viewModelGoogleBooks.initGoogleBooks()
    }
    val listBooks = viewModel.stateValueBook.collectAsState().value
    val listBooksGoogle = viewModelGoogleBooks.requestGoogleBooks.collectAsState().value

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(R.string.sub_title_resume_books),
            style = textStyleTitleAlert
        )

        LazyRow {
            items(listBooks) {
                ListItemDash(navHostController, it)
            }
        }

        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(R.string.sub_title_google_books),
            style = textStyleTitleAlert
        )

        when (listBooksGoogle) {
            is GoogleBooksEvents.LoadBooks -> {
                CircularProgressIndicator()
            }

            is GoogleBooksEvents.GetGoogleBooks -> {
                val volumes = listBooksGoogle.books.items

                LazyRow(modifier = Modifier.padding(top = 16.dp)) {
                    items(volumes) { volume ->
                        ItemListGoogleBooks(volume)
                    }
                }
            }
        }
    }
}