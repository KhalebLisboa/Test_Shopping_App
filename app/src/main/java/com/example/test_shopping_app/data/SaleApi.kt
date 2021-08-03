package com.example.test_shopping_app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SaleApi(){

    companion object {
        private var INSTANCE: Retrofit? = null


        fun getInstance(): Retrofit? {
            if (INSTANCE == null) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }
    }
}