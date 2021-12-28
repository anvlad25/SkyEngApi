package com.example.skyengapi.api

import okhttp3.Interceptor
import okhttp3.Response

object SkyEngApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .build()
        )
}