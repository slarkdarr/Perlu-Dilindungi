package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class News(

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("link")
    val url: List<String>,

    @field:SerializedName("pubDate")
    val date: String
)
