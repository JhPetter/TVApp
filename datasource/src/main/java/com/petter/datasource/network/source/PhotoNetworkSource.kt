package com.petter.datasource.network.source

import com.petter.datasource.network.service.PhotoApi
import com.petter.entity.Photo
import com.petter.usecase.repository.PhotoNetworkRepository
import javax.inject.Inject

class PhotoNetworkSource @Inject constructor(private val photoApi: PhotoApi) :
    PhotoNetworkRepository {
    override suspend fun fetchPhotos(): List<Photo> {
        return photoApi.fetchPhotos().map {
            return emptyList()
        }
    }

    override suspend fun searchPhotos(query: String): List<Photo> {
        return photoApi.searchPhotos(query).map {
            return emptyList()
        }
    }
}