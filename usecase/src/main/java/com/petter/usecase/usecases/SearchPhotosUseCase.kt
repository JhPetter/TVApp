package com.petter.usecase.usecases

import com.petter.usecase.actions.SearchPhotosAction
import com.petter.usecase.repository.PhotoNetworkRepository

internal class SearchPhotosUseCase constructor(private val photoNetworkRepository: PhotoNetworkRepository) :
    SearchPhotosAction {
    override suspend fun invoke(query: String, page: Int) =
        photoNetworkRepository.searchPhotos(query, page)
}