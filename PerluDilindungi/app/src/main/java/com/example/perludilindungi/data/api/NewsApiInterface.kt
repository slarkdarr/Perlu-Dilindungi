package com.example.perludilindungi.data.api


import com.example.perludilindungi.data.model.NewsResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {
    @GET("/api/get-news")
    fun getNews(): Call<NewsResult>
}
