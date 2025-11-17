package com.example.booklist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserModel(
    val email: String = "",
    val password: String = ""
): Parcelable
