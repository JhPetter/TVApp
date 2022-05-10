package com.petter.usecase.di

import com.petter.usecase.actions.FetchPhotosAction
import com.petter.usecase.usecases.FetchPhotosUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface ActionModule {
    @Binds
    fun bindFetchPhotosAction(fetchPhotosUseCase: FetchPhotosUseCase): FetchPhotosAction
}