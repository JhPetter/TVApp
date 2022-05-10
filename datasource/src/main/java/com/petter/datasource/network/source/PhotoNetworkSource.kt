package com.petter.datasource.network.source

import com.petter.datasource.network.service.PhotoApi
import com.petter.entity.Page
import com.petter.entity.Photo
import com.petter.usecase.exceptions.NotFoundException
import com.petter.usecase.repository.PhotoNetworkRepository
import javax.inject.Inject

class PhotoNetworkSource @Inject constructor(private val photoApi: PhotoApi) :
    PhotoNetworkRepository {
    override suspend fun fetchPhotos(page: Int): Page {
        val response = photoApi.fetchPhotos(page)
        if (response.stat == "ok") {
            val photos = response.photos?.photo?.map {
                Photo(
                    it.id ?: "",
                    it.title ?: "",
                    it.datetaken ?: "",
                    it.url_h ?: "",
                    it.ownername ?: ""
                )
            }
            return Page(
                response.photos?.pages ?: 0,
                response.photos?.page ?: 0,
                response.photos?.total ?: 0,
                response.photos?.perpage ?: 0,
                photos ?: arrayListOf()
            )
        } else {
            throw NotFoundException()
        }
    }

    override suspend fun searchPhotos(query: String, page: Int): Page {
        val response = photoApi.searchPhotos(query, page)
        if (response.stat == "ok") {
            val photos = response.photos?.photo?.map {
                Photo(
                    it.id ?: "",
                    it.title ?: "",
                    it.datetaken ?: "",
                    it.url_h ?: "",
                    it.ownername ?: ""
                )
            }
            return Page(
                response.photos?.pages ?: 0,
                response.photos?.page ?: 0,
                response.photos?.total ?: 0,
                response.photos?.perpage ?: 0,
                photos ?: arrayListOf()
            )
        } else {
            throw NotFoundException()
        }
    }
}