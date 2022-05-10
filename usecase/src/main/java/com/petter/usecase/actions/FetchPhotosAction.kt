package com.petter.usecase.actions

import com.petter.entity.Page

fun interface FetchPhotosAction {
    suspend operator fun invoke(page: Int): Page
}