package com.andresmartinez.babylontest.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersEntity(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "username") var username: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "street") var street: String,
    @ColumnInfo(name = "suite") var suite: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "zipcode") var zipcode: String,
    @ColumnInfo(name = "lat") var lat: String,
    @ColumnInfo(name = "lng") var lng: String,
    @ColumnInfo(name = "phone") var phone: String,
    @ColumnInfo(name = "website") var website: String,
    @ColumnInfo(name = "company_name") var company_name: String,
    @ColumnInfo(name = "company_catch_phrase") var company_catch_phrase: String,
    @ColumnInfo(name = "company_bs") var company_bs: String
)
