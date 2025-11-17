package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.booklist.R
import com.example.booklist.model.BooksModel
import com.example.booklist.ui.theme.textStyleDefault

@Composable
fun ListItemDash(navHostController: NavHostController, booksModel: BooksModel) {

    Column(
        modifier = Modifier
            .size(width = 130.dp, height = 200.dp)
            .padding(start = 16.dp)
            .fillMaxSize()
            .clickable {
                navHostController.navigate(booksModel)
            }, verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            modifier = Modifier.size(width = 80.dp, height = 120.dp),
            contentDescription = booksModel.name,
            model = R.drawable.book,
        )

        Text(booksModel.name, style = textStyleDefault)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.size(width = 130.dp, height = 25.dp)
        ) {
            val score = booksModel.score.coerceIn(0..5)
            repeat(score) {
                StartIcon()
            }
        }
    }
}
