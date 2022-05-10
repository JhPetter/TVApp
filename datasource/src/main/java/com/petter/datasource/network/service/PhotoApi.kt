package com.petter.datasource.network.service

import com.petter.datasource.network.model.BaseResponse
import com.petter.datasource.network.model.PhotoResponse

interface PhotoApi {
    suspend fun fetchPhotos(): List<BaseResponse<PhotoResponse>>
    suspend fun searchPhotos(query: String): List<BaseResponse<PhotoResponse>>
}