package com.example.booklist.data.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GoogleBooksResponse(
    @SerializedName("tipo")
    val kind: String?,
    @SerializedName("totalItems")
    val totalItems: Int?,
    @SerializedName("items")
    val items: List<Volume>
) : Parcelable

@Parcelize
data class Volume(
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
) : Parcelable

@Parcelize
data class VolumeInfo(
    @SerializedName("title")
    val title: String,
    @SerializedName("publishedDate")
    val publishedDate: String,
    @SerializedName("imageLinks")
    val imageLinks: Images,

) : Parcelable

@Parcelize
data class Images(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String,
    @SerializedName("thumbnail")
    val thumbnail: String
): Parcelable

