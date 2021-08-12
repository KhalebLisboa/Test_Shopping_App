package com.example.test_shopping_app.data

import com.example.test_shopping_app.domain.Product
import com.example.test_shopping_app.domain.Products
import java.lang.Exception

class SaleRepository() {

    suspend fun fetchProducts() : Result<Products> = try{
        throw Exception("Erro inesperado")
        Result.Success(SaleApi().service().fetchSale().body())
    }catch (e : Exception){
        Result.Error(e)
    }

}