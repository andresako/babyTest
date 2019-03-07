package com.andresmartinez.babylontest.repository

import com.andresmartinez.babylontest.api.ApiService
import com.andresmartinez.babylontest.api.dto.CommentsDto
import com.andresmartinez.babylontest.room.dao.CommentsDao
import com.andresmartinez.babylontest.room.entities.CommentsEntity
import kotlinx.coroutines.runBlocking

class CommentsRepositoryImpl(val service: ApiService, val dao: CommentsDao) : CommentsRepository {
    override suspend fun getAllComments(forceUpdate: Boolean): List<CommentsEntity> {
        if (dao.getComments().isEmpty() || forceUpdate) fetchData()
        return dao.getComments()
    }

    override suspend fun getCount(postId: Int): Int {
        if (dao.getComments().isEmpty()) fetchData()
        return dao.getCommentCount(postId)

    }

    private suspend fun fetchData(){
        val apiResult = service.getComments().await()
        dao.saveComments(toList(apiResult))
    }

    private fun toList(dtoList: List<CommentsDto>): List<CommentsEntity> {
        val entityList: MutableList<CommentsEntity> = mutableListOf()
        for (dto in dtoList) {
            entityList.add(CommentsEntity(dto.id, dto.postId, dto.name, dto.email, dto.body))
        }
        return entityList
    }
}

interface CommentsRepository {
    suspend fun getAllComments(forceUpdate: Boolean): List<CommentsEntity>
    suspend fun getCount(postId: Int): Int
}