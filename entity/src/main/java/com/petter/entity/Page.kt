package com.petter.entity

data class Page(
    val pages: Int,
    val page: Int,
    val total: Int,
    val perPage: Int,
    val photos: List<Photo>
)