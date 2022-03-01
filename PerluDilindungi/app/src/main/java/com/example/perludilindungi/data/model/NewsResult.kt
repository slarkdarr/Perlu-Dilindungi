package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class NewsResult (
    @field:SerializedName("message")
    val status: String,

    @field:SerializedName("count_total")
    val count: String,

    @field:SerializedName("results")
    val results: List<News>,
)