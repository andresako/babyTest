package com.andresmartinez.babylontest.api.dto

import com.google.gson.annotations.SerializedName

data class CommentsDto(
    @SerializedName("postId") val postId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("body") val body: String
)