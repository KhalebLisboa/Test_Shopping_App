package com.example.test_shopping_app.data

import com.example.test_shopping_app.domain.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SalesRepository(private val service: SaleService) : ISalesRepository {

    override suspend fun fetchProducts(): List<Product> {
        return service.fetchSale().body()?.products!!
    }

}