package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.booklist.data.api.Volume
import com.example.booklist.ui.theme.textStyleDefault

@Composable
fun ItemListGoogleBooks(googleBooks: Volume) {

    val secureImageUrl = googleBooks.volumeInfo.imageLinks.thumbnail
        .replace("http://", "https://")

    Column(
        modifier = Modifier
            .padding(top = 16.dp, end = 16.dp)
            .size(height = 250.dp, width = 120.dp)
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(8.dp),
            modifier = Modifier
                .size(height = 150.dp, width = 120.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "",
                    model = secureImageUrl,
                    contentScale = ContentScale.Crop
                )
            }
        }

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = googleBooks.volumeInfo.title,
            style = textStyleDefault
        )
    }
}