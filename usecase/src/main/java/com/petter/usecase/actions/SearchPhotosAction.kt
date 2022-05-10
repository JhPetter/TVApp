package com.petter.usecase.actions

import com.petter.entity.Page

fun interface SearchPhotosAction {
    suspend operator fun invoke(query: String, page: Int): Page
}