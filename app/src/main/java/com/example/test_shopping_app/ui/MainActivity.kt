package com.example.test_shopping_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test_shopping_app.databinding.ActivityMainBinding
import com.example.test_shopping_app.domain.Products
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val liveData = MutableLiveData<Response<Products>>()
    private lateinit var view: View

    private val _showToast: MutableLiveData<Boolean> = MutableLiveData()
    private val showToast: LiveData<Boolean> = _showToast

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        view = bind.root
        setContentView(view)

//        bind.toolbar.setNavigationOnClickListener {
//            onBackPressed()
//        }
        setSupportActionBar(bind.toolbar)
    }
}

