package com.example.booklist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BooksModel(
    @SerialName("name")
    val name: String = "",
    @SerialName("image")
    val image: String = "",
    @SerialName("description")
    val description: String = "",
    @SerialName("score")
    val score: Int = 0,
    @SerialName("author")
    val author: String = "",
    @SerialName("index")
    val index: String = ""
): Parcelable