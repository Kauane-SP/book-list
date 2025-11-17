package com.example.booklist.ui.theme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booklist.model.UserModel
import com.example.booklist.providers.UserRegisterServiceProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class UserAuthViewModel(
    private val provider: UserRegisterServiceProvider
) : ViewModel() {

    private val _registerUserEvent = MutableSharedFlow<BookEvents>()
    val registerUserEvent: MutableSharedFlow<BookEvents> = _registerUserEvent

    private val _authenticationUser = MutableSharedFlow<BookEvents>()
    val authenticationUser: MutableSharedFlow<BookEvents> = _authenticationUser

    private val _resetUserPassword = MutableSharedFlow<BookEvents>()
    val resetUserPassword: MutableSharedFlow<BookEvents> = _resetUserPassword

    fun registerUser(user: UserModel) {
        viewModelScope.launch {
            runCatching {
                provider.getUserRegister(user.email, user.password)
            }.onSuccess {
                _registerUserEvent.emit(BookEvents.Success)
            }.onFailure { exception ->
                _registerUserEvent.emit(
                    BookEvents.Error(
                        message = exception.message ?: "Erro desconhecido"
                    )
                )
            }
        }
    }

    fun authenticationUser(user: UserModel) {
        viewModelScope.launch {
            runCatching {
                provider.requestUserLogin(user.email, user.password)
            }.onSuccess {
                _authenticationUser.emit(BookEvents.Success)
            }.onFailure { exception ->
                _authenticationUser.emit(BookEvents.Error(message = exception.message ?: "Erro desconhecido"))
            }
        }
    }

    fun resetPassword(email: String) {
        viewModelScope.launch {
            runCatching {
                provider.resetUserPassword(email)
            }.onSuccess {
                _resetUserPassword.emit(BookEvents.Success)
            }.onFailure { exception ->
                _resetUserPassword.emit(BookEvents.Error(message = exception.message ?: "Erro desconhecido"))
            }
        }
    }
}