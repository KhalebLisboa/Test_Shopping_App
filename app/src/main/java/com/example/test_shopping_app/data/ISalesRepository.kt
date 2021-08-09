package com.example.test_shopping_app.data

import com.example.test_shopping_app.domain.Product

interface ISalesRepository {

    suspend fun fetchProducts() : List<Product>
}