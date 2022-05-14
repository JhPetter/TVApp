package com.petter.mytvapp.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String, posterWidth: Int, posterHeight: Int) {
    if (url.isEmpty()) return
    Picasso.get()
        .load(url)
        .resize(posterWidth, posterHeight)
        .centerCrop()
        .into(this)

}

fun ImageView.loadImage(url: String) {
    if (url.isEmpty()) return
    Picasso.get()
        .load(url)
        .into(this)
}