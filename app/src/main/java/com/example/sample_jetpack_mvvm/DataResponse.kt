package com.example.sample_jetpack_mvvm

import com.google.gson.annotations.SerializedName

data class DataResponse(

	@field:SerializedName("entries")
	val entries: List<EntriesItem?>? = null,

	@field:SerializedName("count")
	val count: Int? = null
)

data class EntriesItem(

	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("Category")
	val category: String? = null,

	@field:SerializedName("HTTPS")
	val hTTPS: Boolean? = null,

	@field:SerializedName("Auth")
	val auth: String? = null,

	@field:SerializedName("API")
	val aPI: String? = null,

	@field:SerializedName("Cors")
	val cors: String? = null,

	@field:SerializedName("Link")
	val link: String? = null
)
