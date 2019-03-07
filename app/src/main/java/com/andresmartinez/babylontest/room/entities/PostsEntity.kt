package com.andresmartinez.babylontest.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostsEntity(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "userId") var userId: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "body") var body: String
)
