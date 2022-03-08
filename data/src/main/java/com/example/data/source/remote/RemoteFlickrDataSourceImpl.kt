package com.example.data.source.remote

import androidx.lifecycle.LiveData
import com.example.webservice.api.NetworkManager
import com.example.domain.model.FlickrResponse
import com.example.webservice.model.ApiResponse

class RemoteFlickrDataSourceImpl : RemoteFlickrDataSource {

    private val flickrService = NetworkManager.createFlickService()

    override fun fetchPhotos(queryParams: QueryParams<String, String>): LiveData<ApiResponse<FlickrResponse>> {
        return flickrService.fetchPhotos(queryParams.getParams())
    }
}