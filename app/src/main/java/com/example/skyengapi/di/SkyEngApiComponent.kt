package com.example.skyengapi.di

import com.example.skyengapi.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, RepositoryModule::class])
interface SkyEngApiComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun build(): SkyEngApiComponent
    }
}