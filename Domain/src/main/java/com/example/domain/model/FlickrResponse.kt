package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class FlickrResponse(
    @SerializedName("photos")
    val photoRequest: PhotoResponse,
    @SerializedName("stat")
    val status: String
)