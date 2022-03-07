package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class FlickrResponse(
    @SerializedName("photos")
    val photoResponse: PhotoResponse,
    @SerializedName("stat")
    val status: String
)