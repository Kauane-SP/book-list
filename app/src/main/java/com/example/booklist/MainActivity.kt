package com.example.booklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.booklist.ui.theme.BookListTheme
import com.example.booklist.ui.theme.screens.HomeTabRow
import com.example.booklist.ui.theme.screens.TopBarBookList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookListTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBarBookList() }) { innerPadding ->
                    HomeTabRow(innerPadding)
                }
            }
        }
    }
}