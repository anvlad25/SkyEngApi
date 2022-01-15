package com.example.skyengapi.data

import com.example.skyengapi.api.SkyEngApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WordsRepoImpl (private val wordsRepo: SkyEngApi) : WordsRepo {
    override fun getWords(searchWord: String): Single<List<SkyEngWords>> =
        wordsRepo.searchWord(searchWord)
}