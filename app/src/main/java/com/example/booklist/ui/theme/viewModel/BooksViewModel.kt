package com.example.booklist.ui.theme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booklist.model.BooksModel
import com.example.booklist.providers.StorageServiceProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BooksViewModel(private val storageServiceProvider: StorageServiceProvider) : ViewModel() {

    private val _stateValueBook = MutableStateFlow<List<BooksModel>>(emptyList())
    val stateValueBook: StateFlow<List<BooksModel>> = _stateValueBook

    private val _operationDeleteEvent = MutableSharedFlow<BookEvents>()
    val operationDeleteEvent: SharedFlow<BookEvents> = _operationDeleteEvent

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

    fun deleteItemList(id: String) {
        viewModelScope.launch {
            runCatching {
                storageServiceProvider.deleteBooks(id)
            }.onSuccess {
                _operationDeleteEvent.emit(BookEvents.Success)
            }.onFailure { exception ->
                _operationDeleteEvent.emit(BookEvents.Error(exception.message ?: "Erro desconhecido"))
            }
        }
    }
}