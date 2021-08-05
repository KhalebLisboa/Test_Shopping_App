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


//        bind.toolbar.setupWithNavController(findNavController(R.id.action_mainFragment_to_informationFragment))

        getRequisition()
        setupObservers()
    }


    private fun getRequisition() {
     CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = SaleApi().service().fetchSale()
                liveData.postValue(response)
            } catch (e: Exception) {
                _showToast.postValue(true)
            }
        }
    }


    private fun setupObservers() {

        liveData.observe(this, {

            bind.frase.setText(it.body()?.products?.get(0)?.name)

            if (it.isSuccessful) {
                Toast.makeText(applicationContext, "Foi ", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Foi não ", Toast.LENGTH_LONG).show()

            }
        })

        showToast.observe(this, {
            if (it) Toast.makeText(applicationContext, "Falha", Toast.LENGTH_LONG).show()
        })
    }
}

