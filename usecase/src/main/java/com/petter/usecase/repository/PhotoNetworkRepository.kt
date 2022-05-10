package com.petter.usecase.repository

import com.petter.entity.Photo

interface PhotoNetworkRepository {
    fun fetchPhotos(): List<Photo>
    fun searchPhotos(query: String): List<Photo>
}