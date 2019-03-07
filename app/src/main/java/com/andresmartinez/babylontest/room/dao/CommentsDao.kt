package com.andresmartinez.babylontest.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andresmartinez.babylontest.room.entities.CommentsEntity

@Dao
interface CommentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveComments(postsList: List<CommentsEntity>)

    @Query("SELECT * FROM comments")
    fun getComments(): List<CommentsEntity>

    @Query("SELECT COUNT(*) FROM comments WHERE postId = :postId")
    fun getCommentCount(postId: Int): Int
}