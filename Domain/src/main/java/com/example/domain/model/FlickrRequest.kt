package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class FlickrRequest(
    @SerializedName("photos")
    val photoRequest: PhotoRequest,
    @SerializedName("stat")
    val status: String
)