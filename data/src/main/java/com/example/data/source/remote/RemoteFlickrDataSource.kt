package com.example.data.source.remote

import androidx.lifecycle.LiveData
import com.example.domain.model.FlickrResponse
import com.example.webservice.model.ApiResponse

interface RemoteFlickrDataSource {

    fun fetchPhotos(
        queryParams: QueryParams<String, String>
    ): LiveData<ApiResponse<FlickrResponse>>

}