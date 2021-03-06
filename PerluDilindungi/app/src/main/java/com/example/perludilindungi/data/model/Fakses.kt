package com.example.perludilindungi.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fakses(

	@field:SerializedName("count_total")
	val countTotal: Int,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("data")
	val results: List<FaksesResult>
) : Parcelable