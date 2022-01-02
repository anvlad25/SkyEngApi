package com.example.skyengapi.data

import com.example.skyengapi.api.SkyEngApi
import com.example.skyengapi.api.SkyEngApiFactory
import io.reactivex.rxjava3.core.Single

class WordsRepo(private val wordsRepo: SkyEngApi = SkyEngApiFactory.create()) {
    fun getWords(searchWord: String): Single<List<SkyEngWords>> =
        wordsRepo.searchWord(searchWord)
}