package com.petter.usecase.repository

import com.petter.entity.Page

interface PhotoNetworkRepository {
    suspend fun fetchPhotos(page: Int): Page
    suspend fun searchPhotos(query: String, page: Int): Page
}