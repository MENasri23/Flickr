package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    val page: Int,
    val pages: Int,
    @SerializedName("perpage")
    val perPage: Int,
    @SerializedName("photo")
    val photos: List<PhotoItem>,
    val total: Int
)