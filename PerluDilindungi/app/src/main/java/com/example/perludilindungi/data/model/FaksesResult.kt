package com.example.perludilindungi.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_bookmark")
@Parcelize
data class FaksesResult(

	@field:SerializedName("provinsi")
	val provinsi: String,

	@field:SerializedName("kota")
	val kota: String,

	@field:SerializedName("telp")
	val telp: String,

	@field:SerializedName("source_data")
	val sourceData: String,

	@field:SerializedName("latitude")
	val latitude: String,

	@field:SerializedName("alamat")
	val alamat: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("kode")
	val kode: String,

	@field:SerializedName("kelas_rs")
	val kelasRs: String,

	@field:SerializedName("jenis_faskes")
	val jenisFaskes: String,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int,

//	@field:SerializedName("detail")
//	val detail: List<FaksesDetail>,

	@field:SerializedName("longitude")
	val longitude: String,

	@field:SerializedName("status")
	val status: String
): Parcelable