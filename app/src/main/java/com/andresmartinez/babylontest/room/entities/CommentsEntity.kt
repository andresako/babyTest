package com.andresmartinez.babylontest.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "comments")
data class CommentsEntity(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "postId") var postId: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "body") var body: String
)
