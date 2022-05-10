package com.petter.datasource.network.di

import com.petter.datasource.network.source.PhotoNetworkSource
import com.petter.usecase.repository.PhotoNetworkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    fun bindPhotoNetworkSource(photoNetworkSource: PhotoNetworkSource): PhotoNetworkRepository
}