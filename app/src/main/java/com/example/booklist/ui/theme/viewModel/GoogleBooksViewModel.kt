package com.example.booklist.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booklist.providers.RequestApiBooksProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class GoogleBooksViewModel(private val provider: RequestApiBooksProvider) : ViewModel() {

    private val _requestGoogleBooks = MutableStateFlow<GoogleBooksEvents>(GoogleBooksEvents.LoadBooks)
    val requestGoogleBooks: MutableStateFlow<GoogleBooksEvents> = _requestGoogleBooks

    fun initGoogleBooks() {
        getGoogleBooks()
    }

    private fun getGoogleBooks() {
        viewModelScope.launch {
           provider.getApiBooks()
               .catch { exception ->
                   exception.message?.let { Log.e("ERRO", it) }
               }
               .collect { films ->
               _requestGoogleBooks.value = GoogleBooksEvents.GetGoogleBooks(films)
                   films.items
           }
        }
    }
}