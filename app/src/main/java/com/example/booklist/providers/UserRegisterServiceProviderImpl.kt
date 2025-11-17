package com.example.booklist.providers

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

class UserRegisterServiceProviderImpl: UserRegisterServiceProvider {

    val auth = Firebase.auth

    override fun getUserRegister(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun requestUserLogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun resetUserPassword(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }
}