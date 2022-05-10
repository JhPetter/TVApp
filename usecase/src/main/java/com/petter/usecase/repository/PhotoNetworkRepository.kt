package com.petter.usecase.repository

import com.petter.entity.Photo

interface PhotoNetworkRepository {
    suspend fun fetchPhotos(): List<Photo>
    suspend fun searchPhotos(query: String): List<Photo>
}