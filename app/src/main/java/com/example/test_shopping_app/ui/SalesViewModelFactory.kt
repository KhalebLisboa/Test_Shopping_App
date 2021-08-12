package com.example.test_shopping_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test_shopping_app.data.SaleRepository

class SalesViewModelFactory(private val repository: SaleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SaleViewModel(repository) as T
    }
}