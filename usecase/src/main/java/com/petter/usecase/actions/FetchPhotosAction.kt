package com.petter.usecase.actions

import com.petter.entity.Photo

fun interface FetchPhotosAction {
    suspend operator fun invoke(): List<Photo>
}