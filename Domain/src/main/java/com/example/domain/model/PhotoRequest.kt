package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class PhotoRequest(
    val page: Int,
    val pages: Int,
    @SerializedName("perpage")
    val perPage: Int,
    @SerializedName("photo")
    val photos: List<Photo>,
    val total: Int
)