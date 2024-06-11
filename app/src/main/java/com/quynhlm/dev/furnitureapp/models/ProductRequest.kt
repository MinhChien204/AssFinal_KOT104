package com.quynhlm.dev.furnitureapp.models

import com.google.gson.annotations.SerializedName

data class ProductRequest(
    @SerializedName("id") var id: String? = null,
    val name: String,
    val avatar: String,
    val price: Int,
)

data class StatusResponse(
    val status: Int,
    val message: String
)