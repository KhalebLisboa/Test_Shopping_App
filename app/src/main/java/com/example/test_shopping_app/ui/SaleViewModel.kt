package com.example.test_shopping_app.ui
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_shopping_app.data.Result
import com.example.test_shopping_app.data.SaleRepository
import com.example.test_shopping_app.domain.Products
import kotlinx.coroutines.launch

class SaleViewModel(
    private val repository: SaleRepository
) : ViewModel() {

    private val _products : MutableLiveData<Products> = MutableLiveData()
    val products : LiveData<Products> = _products


    fun getProducts(){
        viewModelScope.launch {
            when(val result = repository.fetchProducts()){
                is Result.Success -> {
                    Log.i("ResultSucess", "Sucess")
                    _products.value = result.data!!
                }
                is Result.Error -> Log.i("ResultError",result.exception.message!!)
            }
        }
    }

}