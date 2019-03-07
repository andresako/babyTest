package com.andresmartinez.babylontest.di

import com.andresmartinez.babylontest.repository.*
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { CommentsRepositoryImpl(service = get(), dao = get()) as CommentsRepository }
    factory { UsersRepositoryImpl(service = get(), dao = get()) as UsersRepository }
    factory { PostsRepositoryImpl(service = get(), dao = get()) as PostsRepository }
}