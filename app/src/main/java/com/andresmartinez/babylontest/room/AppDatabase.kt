package com.andresmartinez.babylontest.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.andresmartinez.babylontest.room.dao.CommentsDao
import com.andresmartinez.babylontest.room.dao.PostsDao
import com.andresmartinez.babylontest.room.dao.UsersDao
import com.andresmartinez.babylontest.room.entities.CommentsEntity
import com.andresmartinez.babylontest.room.entities.PostsEntity
import com.andresmartinez.babylontest.room.entities.UsersEntity

@Database(
    entities = [
        PostsEntity::class,
        UsersEntity::class,
        CommentsEntity::class
    ], version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
    abstract fun usersDao(): UsersDao
    abstract fun commentsDao(): CommentsDao
}