package com.petter.mytvapp.utils

import android.widget.ImageView
import coil.load
import coil.size.Scale

fun ImageView.loadImage(url: String, posterWidth: Int, posterHeight: Int) {
    load(url, builder = {
        scale(Scale.FIT)
        size(posterWidth, posterHeight)
        allowHardware(false)
    })
}

fun ImageView.loadImage(url: String) {
    load(url)
}