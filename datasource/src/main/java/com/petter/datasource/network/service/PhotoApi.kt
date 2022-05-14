package com.petter.datasource.network.service

import com.petter.datasource.network.model.BaseResponse
import com.petter.datasource.network.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {
    @GET("?method=flickr.interestingness.getList&extras=date_taken,url_h,owner_name&per_page=10")
    suspend fun fetchPhotos(@Query("page") page: Int): BaseResponse<PhotoResponse>

    @GET("?method=flickr.photos.search&extras=date_taken,url_h,owner_name&per_page=10")
    suspend fun searchPhotos(@Query("text")query: String, @Query("page") page: Int): BaseResponse<PhotoResponse>
}