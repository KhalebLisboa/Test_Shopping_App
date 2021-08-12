package com.example.test_shopping_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.test_shopping_app.R
import com.example.test_shopping_app.data.SaleApi
import com.example.test_shopping_app.databinding.ActivityMainBinding
import com.example.test_shopping_app.domain.Product
import com.example.test_shopping_app.domain.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val liveData = MutableLiveData<Response<Products>>()
    private lateinit var view: View

    private val _showToast: MutableLiveData<Boolean> = MutableLiveData()
    val showToast: LiveData<Boolean> = _showToast

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        view = bind.root
        setContentView(view)


    }

}

