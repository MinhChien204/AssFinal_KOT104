package com.quynhlm.dev.furnitureapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://666726a3a2f8516ff7a67e71.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val productService: ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }
}
