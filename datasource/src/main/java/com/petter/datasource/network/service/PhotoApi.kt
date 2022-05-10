package com.petter.datasource.network.service

import com.petter.datasource.network.model.BaseResponse
import com.petter.datasource.network.model.PhotoResponse
import retrofit2.http.GET

interface PhotoApi {
    @GET("https://www.flickr.com/services/rest/?method=flickr.interestingness.getList&api_key=dcd581385dcfc96545c82d330ece0994&format=json&nojsoncallback=1&extras=date_taken,url_h,owner_name")
    suspend fun fetchPhotos(): List<BaseResponse<PhotoResponse>>
    @GET("https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=dcd581385dcfc96545c82d330ece0994&format=json&nojsoncallback=1&extras=date_taken,url_h,owner_name&text=flags&primary_photo_extras=owner_name")
    suspend fun searchPhotos(query: String): List<BaseResponse<PhotoResponse>>
}