package com.andresmartinez.babylontest.repository

import com.andresmartinez.babylontest.api.ApiService
import com.andresmartinez.babylontest.api.dto.UsersDto
import com.andresmartinez.babylontest.room.dao.UsersDao
import com.andresmartinez.babylontest.room.entities.UsersEntity

class UsersRepositoryImpl(val service: ApiService, val dao: UsersDao) : UsersRepository {
    override suspend fun getAllUsers(forceUpdate: Boolean): List<UsersEntity> {
        if (dao.getUsers().isEmpty() || forceUpdate) { fetchData() }
        return dao.getUsers()
    }

    override suspend fun getUserById(userId: Int): UsersEntity {
        if (dao.getUsers().isEmpty()) { fetchData() }
        return dao.getUserById(userId)
    }

    private suspend fun fetchData(){
        val apiResult = service.getUsers().await()
        dao.saveUsers(toList(apiResult))
    }

    private fun toList(dtoList: List<UsersDto>): List<UsersEntity> {
        val entityList: MutableList<UsersEntity> = mutableListOf()
        for (dto in dtoList) {
            entityList.add(
                UsersEntity(
                    dto.id,
                    dto.name,
                    dto.username,
                    dto.email,
                    dto.address.street,
                    dto.address.suite,
                    dto.address.city,
                    dto.address.zipcode,
                    dto.address.geo.lat,
                    dto.address.geo.lng,
                    dto.phone,
                    dto.website,
                    dto.company.name,
                    dto.company.catchPhrase,
                    dto.company.bs
                )
            )
        }
        return entityList
    }
}

interface UsersRepository {
    suspend fun getAllUsers(forceUpdate: Boolean): List<UsersEntity>
    suspend fun getUserById(userId: Int): UsersEntity
}