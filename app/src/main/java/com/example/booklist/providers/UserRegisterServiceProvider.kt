package com.example.booklist.providers

interface UserRegisterServiceProvider {
    fun getUserRegister(email: String, password: String)

    suspend fun requestUserLogin(email: String, password: String)

    suspend fun resetUserPassword(email: String)
}