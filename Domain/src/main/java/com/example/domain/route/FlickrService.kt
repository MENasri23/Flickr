package com.example.domain.route

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FlickrService {

    @GET("/rest/")
    fun fetchPhotos(@QueryMap params: Map<String, String>): String


}

