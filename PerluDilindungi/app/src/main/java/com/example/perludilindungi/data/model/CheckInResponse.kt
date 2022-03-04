package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class CheckInResponse(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: List<String>
)
