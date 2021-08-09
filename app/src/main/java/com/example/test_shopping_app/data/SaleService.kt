package com.example.test_shopping_app.data

import com.example.test_shopping_app.domain.Product
import com.example.test_shopping_app.domain.Products
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.java.KoinJavaComponent.inject
import retrofit
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SaleService {

    @GET("59b6a65a0f0000e90471257d")
    suspend fun fetchSale(): Response<Products>

}