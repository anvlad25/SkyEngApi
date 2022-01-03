package com.example.skyengapi.di

import com.example.skyengapi.data.WordsRepo
import com.example.skyengapi.data.WordsRepoImpl
import com.example.skyengapi.ui.main.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [NetworkModule::class])
interface RepositoryModule {
    @ContributesAndroidInjector
    fun bindMainFragment(): MainFragment

    @Binds
    fun bindWordsRepo(
        wordsRepo: WordsRepoImpl
    ): WordsRepo
}