package com.example.test_shopping_app.di

import com.example.test_shopping_app.data.ISalesRepository
import com.example.test_shopping_app.data.SaleService
import com.example.test_shopping_app.data.SalesRepository
import org.koin.dsl.module
import retrofit


val dataModules = module {

    single { retrofit.create(SaleService::class.java) }

    single<ISalesRepository> { SalesRepository(get()) }

}
