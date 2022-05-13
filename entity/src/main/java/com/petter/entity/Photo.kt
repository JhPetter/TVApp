package com.petter.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val title: String,
    val publishDate: String,
    val url: String,
    val authorName: String
) : Parcelable