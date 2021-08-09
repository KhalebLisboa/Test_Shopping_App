package com.example.test_shopping_app.data

import com.example.test_shopping_app.domain.Product

class MockedSalesRepository(private val saleService: SaleService) : ISalesRepository {
    override suspend fun fetchProducts(): List<Product> {
        return listOf(
            Product(
                "Khaleb",
                "",
                false,
                "",
                "",
                "", "",
                "https://coltechconsultoria.com.br/img/membros/khaleb.jpg",
                listOf()
            )
        )
    }
}