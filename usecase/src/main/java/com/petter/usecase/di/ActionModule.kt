package com.petter.usecase.di

import com.petter.usecase.actions.FetchPhotosAction
import com.petter.usecase.actions.SearchPhotosAction
import com.petter.usecase.usecases.FetchPhotosUseCase
import com.petter.usecase.usecases.SearchPhotosUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface ActionModule {
    @Binds
    fun bindFetchPhotosAction(fetchPhotosUseCase: FetchPhotosUseCase): FetchPhotosAction
    @Binds
    fun bindFetchPhotoSearchAction(searchPhotosUseCase: SearchPhotosUseCase): SearchPhotosAction
}