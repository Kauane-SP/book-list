package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.booklist.model.BooksModel
import com.example.booklist.ui.theme.textStyleDefault

@Composable
fun ListItemDash(navHostController: NavHostController, booksModel: BooksModel) {

    Row(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .fillMaxSize()
            .clickable {
                navHostController.navigate(booksModel)
            }) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(6.dp),
            modifier = Modifier.size(height = 120.dp, width = 100.dp)
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
        Column(Modifier.padding(start = 16.dp)) {
            Text(booksModel.name, style = textStyleDefault, modifier = Modifier.padding(top = 8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {}) { StartIcon() }
                Text(booksModel.score.toString(), style = textStyleDefault)
            }
            Text(booksModel.author, style = textStyleDefault)
        }
    }
}