package com.petter.datasource.network.model

data class BaseResponse<T>(val photos: T? = null, val stat: String)