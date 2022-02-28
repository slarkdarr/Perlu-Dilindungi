package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class Fakses(

	@field:SerializedName("count_total")
	val countTotal: Int,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("results")
	val results: List<FaksesResult>
)