package com.example.booklist.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.booklist.R
import com.example.booklist.model.BooksModel
import com.example.booklist.ui.theme.textStyleButton
import com.example.booklist.ui.theme.textStyleDefault
import com.example.booklist.ui.theme.textStyleSinopse
import com.example.booklist.ui.theme.viewModel.BookEvents
import com.example.booklist.ui.theme.viewModel.BooksViewModel
import org.koin.compose.viewmodel.koinViewModel

@SuppressLint("ResourceAsColor")
@Composable
fun ItemBook(
    booksModel: BooksModel,
    navHostController: NavHostController,
    viewModel: BooksViewModel = koinViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.initVieModel()
        viewModel.operationDeleteEvent.collect { event ->
            showDialog = when (event) {
                BookEvents.Success -> {
                    false
                }

                is BookEvents.Error -> {
                    true
                }
            }
        }
    }

    if (showDialog) {
        AlertErrorDialog(onBack = { navHostController.popBackStack() })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, top = 24.dp)
    ) {
        Row {
            Card(
                elevation = CardDefaults.elevatedCardElevation(8.dp),
                modifier = Modifier.size(height = 160.dp, width = 120.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = booksModel.name,
                        model = booksModel.image,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = booksModel.name,
                    style = textStyleDefault,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = booksModel.author,
                    style = textStyleDefault,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = "${stringResource(R.string.book_send_title)} ${booksModel.name}",
                    style = textStyleDefault
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = stringResource(R.string.book_note_title), style = textStyleDefault)
                    LazyRow {
                        items(booksModel.score) {
                            StartIcon()
                        }
                    }
                }
            }
        }
        Text(
            text = stringResource(R.string.title_synopsis),
            style = textStyleDefault,
            modifier = Modifier.padding(top = 24.dp)
        )
        Text(
            text = booksModel.description,
            style = textStyleSinopse,
            modifier = Modifier.padding(top = 16.dp, end = 16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            ElevatedButton(
                onClick = {},
                modifier = Modifier.padding(start = 16.dp),
                border = BorderStroke(color = colorResource(R.color.purple_200), width = 1.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "",
                        tint = colorResource(R.color.purple_200),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        stringResource(R.string.button_edit),
                        style = textStyleButton,
                        color = colorResource(R.color.purple_200),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            ElevatedButton(
                onClick = { viewModel.deleteItemList(booksModel.index) },
                modifier = Modifier.padding(start = 16.dp),
                border = BorderStroke(color = colorResource(R.color.purple_200), width = 1.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = colorResource(R.color.purple_200),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        stringResource(R.string.button_exclude),
                        style = textStyleButton,
                        color = colorResource(R.color.purple_200),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}