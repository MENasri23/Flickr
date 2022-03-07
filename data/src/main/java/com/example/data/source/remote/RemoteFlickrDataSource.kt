package com.example.data.source.remote

import androidx.lifecycle.LiveData
import com.example.domain.model.FlickrResponse
import com.example.webservice.model.ApiResponse

interface RemoteFlickrDataSource {

    fun fetchPhotos(

    ): LiveData<ApiResponse<FlickrResponse>>

}