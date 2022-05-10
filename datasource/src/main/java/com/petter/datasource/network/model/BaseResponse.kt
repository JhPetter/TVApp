package com.petter.datasource.network.model

data class BaseResponse<T>(val photos: T, val stat: String)