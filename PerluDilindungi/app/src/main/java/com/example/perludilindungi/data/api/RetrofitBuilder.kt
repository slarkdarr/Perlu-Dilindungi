package com.example.perludilindungi.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitBuilder {
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    }
    fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://perludilindungi.herokuapp.com/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getRetrofit()= buildRetrofit().create(ApiInterface::class.java)


}
