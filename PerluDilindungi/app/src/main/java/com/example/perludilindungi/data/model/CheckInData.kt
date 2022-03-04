package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class CheckInData(

    @field:SerializedName("userStatus")
    val userStatus: String,

    @field:SerializedName("reason")
    val reason: String
)
