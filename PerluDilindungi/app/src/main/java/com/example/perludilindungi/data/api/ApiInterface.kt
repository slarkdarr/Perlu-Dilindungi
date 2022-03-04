package com.example.perludilindungi.data.api

import com.example.perludilindungi.data.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("api/get-news")
    fun getNews(): Call<NewsResult>

    @GET("api/get-province")
    fun getProvince(): Call<Province>

    @GET("api/get-city")
    fun getCity(@Query("start_id") start_id: String): Call<City>

    @GET("api/get-faskes-vaksinasi")
    fun getFakses(@Query("province") province: String,@Query("city") city: String): Call<Fakses>

    @POST("check-in")
    fun postCheckIn(@Body checkInBody: CheckIn): Call<CheckInResponse>
}