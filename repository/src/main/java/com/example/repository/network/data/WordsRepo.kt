package com.example.repository.network.data

import io.reactivex.rxjava3.core.Single

interface WordsRepo {
    fun getWords(searchWord: String): Single<List<SkyEngWords>>
}