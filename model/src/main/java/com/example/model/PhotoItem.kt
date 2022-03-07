package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class PhotoItem(
    val farm: Int,
    @SerializedName("height_s")
    val height: Int,
    val id: String,
    @SerializedName("isfamily")
    val isFamily: Int,
    @SerializedName("isfriend")
    val isFriend: Int,
    @SerializedName("ispublic")
    val isPublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    @SerializedName("url_s")
    val url: String,
    @SerializedName("width_s")
    val width: Int
)