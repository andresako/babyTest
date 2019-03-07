package com.andresmartinez.babylontest.di

import androidx.room.Room
import com.andresmartinez.babylontest.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val storageModule = module {

    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "AppDatabase").build() }

    single { get<AppDatabase>().postsDao() }
    single { get<AppDatabase>().usersDao() }
    single { get<AppDatabase>().commentsDao() }
}