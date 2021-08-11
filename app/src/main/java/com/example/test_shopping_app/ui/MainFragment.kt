package com.example.test_shopping_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test_shopping_app.data.SaleApi
import com.example.test_shopping_app.databinding.FragmentMainBinding
import com.example.test_shopping_app.domain.Product
import com.example.test_shopping_app.domain.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MainFragment : Fragment() {

    private val liveData = MutableLiveData<Response<Products>>()
    private var listLiveData = MutableLiveData<List<Product>>(listOf())
    private  lateinit var binding: FragmentMainBinding
    private lateinit var viewMainFragment : View
    private lateinit var adapter: RecyclerAdapter
    private val _showToast: MutableLiveData<Boolean> = MutableLiveData()
    val showToast: LiveData<Boolean> = _showToast
    private val lista = listOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        viewMainFragment = binding.root
        return viewMainFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecyclerAdapter(listLiveData.value!!, this.requireContext())
        binding.recycler.adapter = adapter

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

        liveData.observe(viewLifecycleOwner, {


            if (it.isSuccessful) {
                Toast.makeText(this.requireContext(), "Foi ", Toast.LENGTH_LONG).show()
                listLiveData.value = it.body()?.products!!
            }
            else{
                Toast.makeText(this.requireContext(), "Foi não ", Toast.LENGTH_LONG).show()
            }
        })

        showToast.observe(viewLifecycleOwner, {
            if (it) Toast.makeText(this.requireContext(), "Falha", Toast.LENGTH_LONG).show()
        })
    }
}