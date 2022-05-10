package com.petter.usecase.actions

import com.petter.entity.Photo

fun interface SearchPhotosAction {
    suspend operator fun invoke(query: String): List<Photo>
}