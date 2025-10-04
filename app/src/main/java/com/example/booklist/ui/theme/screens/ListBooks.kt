package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.booklist.model.BooksModel

@Composable
fun DashListBooks() {

    val mockList: List<BooksModel> = List(3) {
        BooksModel(
            "livro teste",
            "",
            "Descriçao teste",
            "5",
            "Author Teste"
        )
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        LazyColumn(Modifier.weight(1f)) {
            items(mockList) {
                ListItemDash(it)
            }
        }
    }
}