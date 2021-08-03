package com.example.test_shopping_app.data

import com.example.test_shopping_app.domain.Product
import retrofit2.Response
import retrofit2.http.GET

interface SaleService {

    @GET("59b6a65a0f0000e90471257d")
    suspend fun fetchSale() : Response<List<Product>>
}