package com.petter.usecase.usecases

import com.petter.entity.Photo
import com.petter.usecase.actions.FetchPhotosAction
import com.petter.usecase.repository.PhotoNetworkRepository

internal class FetchPhotosUseCase constructor(private val photoNetworkRepository: PhotoNetworkRepository) :
    FetchPhotosAction {
    override suspend fun invoke(): List<Photo> = photoNetworkRepository.fetchPhotos()
}