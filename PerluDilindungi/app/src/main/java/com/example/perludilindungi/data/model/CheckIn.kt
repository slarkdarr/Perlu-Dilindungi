package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class CheckIn(

    @field:SerializedName("qrCode")
    val qrCode: String,

    @field:SerializedName("latitude")
    val latitude: Int,

    @field:SerializedName("longitude")
    val longitude: Int
)
