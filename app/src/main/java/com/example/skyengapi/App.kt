package com.example.skyengapi

import com.example.skyengapi.di.DaggerSkyEngApiComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerSkyEngApiComponent
            .builder()
            .build()
}