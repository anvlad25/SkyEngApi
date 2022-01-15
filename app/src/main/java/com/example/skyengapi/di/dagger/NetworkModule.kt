package com.example.skyengapi.di.dagger

import com.example.skyengapi.api.SkyEngApi
import com.example.skyengapi.api.SkyEngApiInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .create()

    @Reusable
    @Provides
    fun provideGetSkyEngApi(gson: Gson): SkyEngApi =
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
}