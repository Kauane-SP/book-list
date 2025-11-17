package com.example.booklist.ui.theme.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.booklist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarBookList() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.purple_200),
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    tint = colorResource(R.color.white),
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.content_description_menu_list)
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    tint = colorResource(R.color.white),
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.content_description_menu_busca)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    tint = colorResource(R.color.white),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(R.string.content_description_menu_favorites)
                )
            }
        }
    )
}