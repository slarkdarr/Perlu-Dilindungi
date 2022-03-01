package com.example.perludilindungi.data.api

import com.example.perludilindungi.data.model.City
import com.example.perludilindungi.data.model.Fakses
import com.example.perludilindungi.data.model.Province
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("get-province")
    fun getProvince(): Call<Province>

    @GET("get-city")
    fun getCity(@Query("start_id") start_id: String): Call<City>

    @GET("get-faskes-vaksinasi")
    fun getFakses(@Query("province") province: String,@Query("city") city: String): Call<Fakses>
}