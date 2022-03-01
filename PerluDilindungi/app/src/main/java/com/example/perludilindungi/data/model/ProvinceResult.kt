package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class ProvinceResult(

	@field:SerializedName("value")
	val value: String,

	@field:SerializedName("key")
	val key: String
)