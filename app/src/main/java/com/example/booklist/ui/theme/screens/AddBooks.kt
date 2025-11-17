package com.example.booklist.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booklist.R
import com.example.booklist.model.BooksModel
import com.example.booklist.ui.theme.textStyleButton
import com.example.booklist.ui.theme.textStyleDefault
import com.example.booklist.ui.theme.viewModel.BookEvents
import com.example.booklist.ui.theme.viewModel.BooksViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddBooks(viewModel: BooksViewModel = koinViewModel()) {

    val booksModel: BooksModel = BooksModel()
    val context = LocalContext.current

    var nameBook by remember { mutableStateOf(booksModel.name) }
    var authorBook by remember { mutableStateOf(booksModel.author) }
    var descriptionBook by remember { mutableStateOf(booksModel.description) }
    var scoreBook by remember { mutableStateOf(booksModel.score.toString()) }
    var launchBook by remember { mutableStateOf(booksModel.launch) }

    LaunchedEffect(Unit) {
        viewModel.initVieModel()

        viewModel.operationAddEvent.collect { event ->
            when (event) {
                BookEvents.Success -> {
                    Toast.makeText(context, "Item salvo com sucesso", Toast.LENGTH_SHORT).show()
                }

                is BookEvents.Error -> {
                    Toast.makeText(context, "Ocorreu um erro ao salvar o livro", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Precha os campos para adicionar um novo livro a sua lista: ",
            style = textStyleDefault
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 16.dp, end = 16.dp, start = 16.dp),
            value = nameBook,
            onValueChange = { nameBook = it },
            singleLine = true,
            label = { Text("name") },
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 8.dp, end = 16.dp, start = 16.dp),
            value = authorBook,
            onValueChange = { authorBook = it },
            singleLine = true,
            label = { Text("author") },
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 8.dp, end = 16.dp, start = 16.dp),
            value = scoreBook,
            onValueChange = { scoreBook = it },
            singleLine = true,
            label = { Text("score") },
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 8.dp, end = 16.dp, start = 16.dp),
            value = launchBook,
            onValueChange = { launchBook = it },
            singleLine = true,
            label = { Text("launch") },
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 8.dp, end = 16.dp, start = 16.dp)
                .size(width = 280.dp, height = 100.dp),
            value = descriptionBook,
            onValueChange = { descriptionBook = it },
            singleLine = false,
            label = { Text("description") },
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, top = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            ElevatedButton(
                onClick = {
                    viewModel.addItemBook(
                        BooksModel(
                            name = nameBook,
                            author = authorBook,
                            description = descriptionBook,
                            score = scoreBook.toInt(),
                            launch = launchBook
                        )
                    )
                },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = colorResource(R.color.purple_500)
                ),
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    stringResource(R.string.button_update),
                    style = textStyleButton,
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}