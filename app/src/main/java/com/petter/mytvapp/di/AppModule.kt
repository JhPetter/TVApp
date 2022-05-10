package com.petter.mytvapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    @Named("api_key")
    fun provideApiKey():String = "dcd581385dcfc96545c82d330ece0994"

    @Provides
    @Singleton
    @Named("base_url")
    fun provideBaseUrl():String = "https://www.flickr.com/services/rest/"


}