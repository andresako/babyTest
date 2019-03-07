package com.andresmartinez.babylontest.api.dto

import com.google.gson.annotations.SerializedName

data class PostsDto(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)