package com.petter.datasource.network.model

data class PhotoItemResponse(
    val id: String? = "",
    val owner: String? = "",
    val secret: String? = "",
    val title: String? = "",
    val datetaken: String? = "",
    val ownername: String? = "",
    val url_h: String? = "",
    val height_h: Int? = 0,
    val width_h: Int? = 0
)