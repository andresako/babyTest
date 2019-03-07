package com.andresmartinez.babylontest.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.andresmartinez.babylontest.room.entities.PostsEntity

@Dao
interface PostsDao{

    @Insert(onConflict = REPLACE)
    fun savePosts(postsList: List<PostsEntity>)

    @Query("SELECT * FROM posts")
    fun getPosts(): List<PostsEntity>

    @Query("SELECT * FROM posts WHERE id = :postId")
    fun getPostId(postId: Int): PostsEntity
}