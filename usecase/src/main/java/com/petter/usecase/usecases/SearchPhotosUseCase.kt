package com.petter.usecase.usecases

import com.petter.usecase.actions.SearchPhotosAction
import com.petter.usecase.repository.PhotoNetworkRepository
import javax.inject.Inject

internal class SearchPhotosUseCase @Inject constructor(private val photoNetworkRepository: PhotoNetworkRepository) :
    SearchPhotosAction {
    override suspend fun invoke(query: String, page: Int) =
        photoNetworkRepository.searchPhotos(query, page)
}