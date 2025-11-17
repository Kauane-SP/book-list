package com.example.booklist.ui.theme.navigation

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class FirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    fun subscribeToBookNotifications() {
        val topic = "new_books_feed"
        FirebaseMessaging.getInstance().subscribeToTopic(topic)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FCM_SUBSCRIBE", "Inscrito no tópico: $topic")
                }
            }
    }
}