package com.example.booklist.ui.theme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booklist.model.BooksModel
import com.example.booklist.providers.StorageServiceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BooksViewModel(private val storageServiceProvider: StorageServiceProvider) : ViewModel() {

    private val _stateValueBook = MutableStateFlow<List<BooksModel>>(emptyList())
    val stateValueBook: StateFlow<List<BooksModel>> = _stateValueBook

    fun initVieModel() {
        getListBooks()
    }

    private fun getListBooks() {
        viewModelScope.launch {
            runCatching {
                storageServiceProvider.getListBooks()
            }.onSuccess {
                _stateValueBook.value = it
            }.onFailure {

            }
        }
    }
}