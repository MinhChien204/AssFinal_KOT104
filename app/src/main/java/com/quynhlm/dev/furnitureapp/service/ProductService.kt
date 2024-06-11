package com.quynhlm.dev.furnitureapp.service

import com.quynhlm.dev.furnitureapp.models.ProductRequest
import com.quynhlm.dev.furnitureapp.models.ProductResponse
import com.quynhlm.dev.furnitureapp.models.StatusResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductService {
    @GET("SanPham")
    suspend fun getListProduct(): Response<List<ProductResponse>>

    @GET("SanPham/{id}")
    suspend fun getProductDetail(@Path("id") id: String): Response<ProductResponse>

    @POST("SanPham")
    suspend fun addProduct(@Body productRequest: ProductRequest): Response<StatusResponse>

    @PUT("SanPham/{id}")
    suspend fun updateProduct(
        @Path("id") id: String,
        @Body productRequest: ProductRequest
    ): Response<StatusResponse>

    @DELETE("SanPham/{id}")
    suspend fun deleteProduct(@Path("id") id: String): Response<StatusResponse>
}