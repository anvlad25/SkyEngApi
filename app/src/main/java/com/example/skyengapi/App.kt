package com.example.skyengapi

import android.app.Application
import com.example.skyengapi.di.koin.DiKoin.skyEngApiModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(skyEngApiModule)
        }
    }
}