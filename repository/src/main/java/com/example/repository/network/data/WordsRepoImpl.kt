package com.example.repository.network.data

import com.example.repository.network.api.SkyEngApi
import io.reactivex.rxjava3.core.Single

class WordsRepoImpl (private val wordsRepo: SkyEngApi) : WordsRepo {
    override fun getWords(searchWord: String): Single<List<SkyEngWords>> =
        wordsRepo.searchWord(searchWord)
}