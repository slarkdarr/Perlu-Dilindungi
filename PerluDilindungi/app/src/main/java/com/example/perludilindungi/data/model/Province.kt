package com.example.perludilindungi.data.model

import com.google.gson.annotations.SerializedName

data class Province(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("curr_val")
	val currVal: String,

	@field:SerializedName("results")
	val results: List<ProvinceResult>
)