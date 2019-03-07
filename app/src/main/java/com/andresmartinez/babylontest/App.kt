package com.andresmartinez.babylontest

import android.app.Application
import com.andresmartinez.babylontest.di.appComponent
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    fun configureDi() = startKoin(this, provideComponent())

    fun provideComponent() = appComponent

}