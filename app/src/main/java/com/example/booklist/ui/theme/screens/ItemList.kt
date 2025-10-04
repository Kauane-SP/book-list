package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.booklist.R
import com.example.booklist.model.BooksModel

@Composable
fun ListItemDash(booksModel: BooksModel) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .fillMaxSize()
    ) {
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
            Text(booksModel.name)
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {}) {
                    Box {
                        Icon(
                            tint = Color.Black,
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                        Icon(
                            tint = Color.Yellow,
                            imageVector = Icons.Default.Star,
                            contentDescription = stringResource(R.string.item_list_icon_start_description),
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                Text(booksModel.score)
            }
            Text(booksModel.author)
        }
    }
}