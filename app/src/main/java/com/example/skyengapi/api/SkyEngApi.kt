package com.example.skyengapi.api

import com.example.skyengapi.data.SkyEngWords
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SkyEngApi {
    @GET("/api/public/v1/words/search")
    fun searchWord(@Query("search") search: String): Single<List<SkyEngWords>>
}