package com.andresmartinez.babylontest.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.andresmartinez.babylontest.room.entities.UsersEntity

@Dao
interface UsersDao {

    @Insert(onConflict = REPLACE)
    fun saveUsers(postsList: List<UsersEntity>)

    @Query("SELECT * FROM users")
    fun getUsers(): List<UsersEntity>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: Int): UsersEntity
}