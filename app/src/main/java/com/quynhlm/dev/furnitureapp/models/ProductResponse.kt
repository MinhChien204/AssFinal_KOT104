package com.quynhlm.dev.furnitureapp.models

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("price") val price: Int,
){
    fun toMovie(): Product {
        return Product(
            id = this.id,
            name = this.name,
            avatar= this.avatar,
            price = this.price,
        )
    }
}