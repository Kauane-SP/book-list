package com.example.booklist.model

import android.os.Parcelable
import com.google.firebase.firestore.DocumentId
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BooksModel(
    @SerialName("name")
    var name: String = "",
    @SerialName("image")
    val image: String = "",
    @SerialName("description")
    val description: String = "",
    @SerialName("score")
    val score: Int = 0,
    @SerialName("author")
    val author: String = "",
    @DocumentId
    @SerialName("id")
    val id: String = "",
    @SerialName("index")
    val index: String = "",
    @SerialName("launch")
    val launch: String = ""
): Parcelable