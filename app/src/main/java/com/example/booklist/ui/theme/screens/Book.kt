package com.example.booklist.ui.theme.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.booklist.R
import com.example.booklist.model.BooksModel
import com.example.booklist.ui.theme.screens.dialog.AlertErrorDialog
import com.example.booklist.ui.theme.subTitleBook
import com.example.booklist.ui.theme.textStyleButton
import com.example.booklist.ui.theme.textStyleDefault
import com.example.booklist.ui.theme.titleItemBook
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
    var showUpdateBook by remember { mutableStateOf(false) }

    var nameBook by remember { mutableStateOf(booksModel.name) }
    var authorBook by remember { mutableStateOf(booksModel.author) }
    var descriptionBook by remember { mutableStateOf(booksModel.description) }
    var indexBook by remember { mutableStateOf(booksModel.index) }
    var scoreBook by remember { mutableIntStateOf(booksModel.score) }
    var launch by remember { mutableStateOf(booksModel.launch) }
    var id by remember { mutableStateOf(booksModel.id) }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.initVieModel()
        viewModel.operationDeleteEvent.collect { event ->
            showDialog = when (event) {
                BookEvents.Success -> {
                    true
                }

                is BookEvents.Error -> {
                    false
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.operationEditEvent.collect { update ->
            showUpdateBook = when (update) {
                BookEvents.Success -> false
                is BookEvents.Error -> true
            }
        }
    }

    if (showDialog) {
        AlertErrorDialog(onBack = { navHostController.popBackStack() })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, end = 16.dp, top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .size(width = 60.dp, height = 100.dp),
            contentDescription = booksModel.name,
            model = R.drawable.book,
        )

        Spacer(modifier = Modifier.height(8.dp))

        InitInlineEditableField(
            valueLabel = "nome",
            valueText = nameBook,
            valueStyle = titleItemBook,
            onValueChange = { nameBook = it },
            isEditable = showUpdateBook
        )

        Spacer(modifier = Modifier.height(8.dp))

        InitInlineEditableField(
            valueLabel = "author",
            valueText = authorBook,
            valueStyle = subTitleBook,
            onValueChange = { authorBook = it },
            isEditable = showUpdateBook
        )

        Spacer(modifier = Modifier.height(8.dp))

        InitInlineEditableField(
            valueLabel = "launch",
            valueText = launch,
            valueStyle = subTitleBook,
            onValueChange = { launch = it },
            isEditable = showUpdateBook
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {
            items(booksModel.score) {
                StartIcon()
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        InitInlineEditableField(
            valueText = descriptionBook,
            valueStyle = textStyleDefault,
            onValueChange = { descriptionBook = it },
            isEditable = showUpdateBook,
            valueLabel = "sinopse",
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            ElevatedButton(
                onClick = {
                    showUpdateBook = true
                },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = colorResource(R.color.purple_500)
                ),
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "",
                        tint = colorResource(R.color.white),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        stringResource(R.string.button_edit),
                        style = textStyleButton,
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            if (showUpdateBook) {
                ElevatedButton(
                    onClick = {
                        viewModel.editItemList(
                            BooksModel(
                                name = nameBook,
                                author = authorBook,
                                description = descriptionBook,
                                score = scoreBook,
                                index = indexBook,
                                id = id,
                                launch = launch
                            )
                        )
                        Toast.makeText(context, "Item salvo", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = colorResource(R.color.purple_500)
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "",
                            tint = colorResource(R.color.white),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            stringResource(R.string.button_save),
                            style = textStyleButton,
                            color = colorResource(R.color.white),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }

            ElevatedButton(
                onClick = { viewModel.deleteItemList(booksModel.id) },
                modifier = Modifier.padding(start = 16.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = colorResource(R.color.purple_500)
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = colorResource(R.color.white),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        stringResource(R.string.button_exclude),
                        style = textStyleButton,
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = { navHostController.popBackStack() }, // Navega para a tela anterior
            modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(24.dp), // Adiciona margem
            containerColor = colorResource(R.color.purple_500)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = colorResource(R.color.white)
            )
        }
    }
}