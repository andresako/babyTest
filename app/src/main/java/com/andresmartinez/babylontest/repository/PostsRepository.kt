package com.andresmartinez.babylontest.repository

import com.andresmartinez.babylontest.api.ApiService
import com.andresmartinez.babylontest.api.dto.PostsDto
import com.andresmartinez.babylontest.room.dao.PostsDao
import com.andresmartinez.babylontest.room.entities.PostsEntity

class PostsRepositoryImpl(val service: ApiService, val dao: PostsDao) : PostsRepository {
    override suspend fun getPostById(postId: Int): PostsEntity {
        if (dao.getPosts().isEmpty()) fetchData()
        return dao.getPostId(postId)
    }

    override suspend fun getAllPosts(forceUpdate: Boolean): List<PostsEntity> {
        if (forceUpdate || dao.getPosts().isEmpty()) fetchData()
        return dao.getPosts()
    }

    private suspend fun fetchData() {
        val apiResult = service.getPosts().await()
        dao.savePosts(toList(apiResult))
    }

    private fun toList(list: List<PostsDto>): List<PostsEntity> {
        val entityList: MutableList<PostsEntity> = mutableListOf()
        for (postsDto in list) {
            entityList.add(PostsEntity(postsDto.id, postsDto.userId, postsDto.title, postsDto.body))
        }
        return entityList
    }
}

interface PostsRepository {
    suspend fun getAllPosts(forceUpdate: Boolean): List<PostsEntity>
    suspend fun getPostById(postId: Int): PostsEntity
}