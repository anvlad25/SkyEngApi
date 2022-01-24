package com.example.skyengapi.di.koin

import androidx.room.Room
import com.example.repository.network.api.SkyEngApi
import com.example.repository.network.api.SkyEngApiInterceptor
import com.example.repository.network.data.WordsRepo
import com.example.repository.network.data.WordsRepoImpl
import com.example.repository.room.WordsDataBase
import com.example.skyengapi.ui.viewmodel.HistoryFragmentViewModel
import com.example.skyengapi.ui.viewmodel.MainFragmentViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
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
        single<WordsRepo> { WordsRepoImpl(getSkyEngApi(gson())) }
        single { Room.databaseBuilder(get(), WordsDataBase::class.java, "HistoryDB").build() }
        single { get<WordsDataBase>().wordsDao() }
        viewModel { MainFragmentViewModel(wordsRepo = get(), wordsDao = get()) }
        viewModel { HistoryFragmentViewModel(wordsDao = get(), scope = CoroutineScope(Dispatchers.IO + SupervisorJob())) }

    }
}