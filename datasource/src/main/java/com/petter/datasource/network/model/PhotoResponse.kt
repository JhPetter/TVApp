package com.petter.datasource.network.model

data class PhotoResponse(
    val page: Int? = 0,
    val pages: Int? = 0,
    val perpage: Int? = 0,
    val total: Int? = 0,
    val photo: List<PhotoItemResponse>? = arrayListOf()
)