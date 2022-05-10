package com.petter.usecase.usecases

import com.petter.entity.Page
import com.petter.entity.Photo
import com.petter.usecase.actions.FetchPhotosAction
import com.petter.usecase.repository.PhotoNetworkRepository
import javax.inject.Inject

internal class FetchPhotosUseCase @Inject constructor(private val photoNetworkRepository: PhotoNetworkRepository) :
    FetchPhotosAction {
    override suspend fun invoke(page: Int): Page = photoNetworkRepository.fetchPhotos(page)
}