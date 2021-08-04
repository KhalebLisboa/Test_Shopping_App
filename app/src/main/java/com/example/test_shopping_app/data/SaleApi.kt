package com.example.test_shopping_app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SaleApi(){

    var INSTANCE: Retrofit? = null
        fun getInstance() : Retrofit{
            if (INSTANCE == null) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE!!
    }

    fun service() : SaleService{
        return getInstance().create(SaleService::class.java)
    }
}