package com.example.checklistappbts.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = "http://18.139.50.74:8080"
    var retrofit: Retrofit? = null
    val API_KEY = "xxxxxx"

    fun getClient():Retrofit? {
        if (retrofit == null) {
            val client = OkHttpClient().newBuilder().addInterceptor{ chain ->
                val request = chain.request()
                    .newBuilder().addHeader("Authorization", API_KEY)
                    .build()
                chain.proceed(request)
            }.build()

            retrofit = Retrofit.Builder()
                .client(client).baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}