package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booklist.R

@Composable
fun StartIcon() {
    Box {
        Icon(
            tint = Color.Black,
            imageVector = Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
        Icon(
            tint = Color.Yellow,
            imageVector = Icons.Default.Star,
            contentDescription = stringResource(R.string.item_list_icon_start_description),
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.Center)
        )
    }
}