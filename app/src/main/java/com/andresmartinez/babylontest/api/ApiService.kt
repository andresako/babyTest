package com.andresmartinez.babylontest.api

import com.andresmartinez.babylontest.api.dto.CommentsDto
import com.andresmartinez.babylontest.api.dto.PostsDto
import com.andresmartinez.babylontest.api.dto.UsersDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPosts(): Deferred<List<PostsDto>>

    @GET("users")
    fun getUsers(): Deferred<List<UsersDto>>

    @GET("comments")
    fun getComments(): Deferred<List<CommentsDto>>

}