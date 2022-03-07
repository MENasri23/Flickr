package com.example.webservice.api

import androidx.lifecycle.LiveData
import com.example.domain.model.FlickrResponse
import com.example.webservice.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FlickrService {

    @GET("/rest/")
    fun fetchPhotos(
        @QueryMap params: Map<String, String>
    ): LiveData<ApiResponse<FlickrResponse>>

}

