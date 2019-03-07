package com.andresmartinez.babylontest.di

import com.andresmartinez.babylontest.ui.MainActivityViewModel
import com.andresmartinez.babylontest.ui.SecondActivityViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(postRepo = get()) }
    viewModel { SecondActivityViewModel(get(), get(), get()) }

}