package com.example.skyengapi.di.koin

import com.example.skyengapi.api.SkyEngApi
import com.example.skyengapi.api.SkyEngApiInterceptor
import com.example.skyengapi.data.WordsRepo
import com.example.skyengapi.data.WordsRepoImpl
import com.example.skyengapi.ui.viewmodel.MainFragmentViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object DiKoin {
    private fun gson(): Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .create()

    private fun getSkyEngApi(gson: Gson): SkyEngApi =
        Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(SkyEngApiInterceptor)
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(SkyEngApi::class.java)

    val skyEngApiModule = module {
        single<WordsRepo>{ WordsRepoImpl(getSkyEngApi(gson())) }
        viewModel { MainFragmentViewModel(wordsRepo = get()) }
    }
}