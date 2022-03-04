package com.example.perludilindungi.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.util.*

data class News(

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("link")
    val url: List<String>,

    @field:SerializedName("pubDate")
    val date: String,

    @field:SerializedName("description")
    val content: JsonObject,

    @field:SerializedName("enclosure")
    val enclosure: JsonObject

)
