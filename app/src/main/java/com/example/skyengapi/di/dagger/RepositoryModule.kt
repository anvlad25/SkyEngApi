package com.example.skyengapi.di.dagger

import com.example.repository.network.data.WordsRepo
import com.example.repository.network.data.WordsRepoImpl
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