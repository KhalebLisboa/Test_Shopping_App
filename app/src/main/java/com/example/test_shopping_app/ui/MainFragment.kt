package com.example.test_shopping_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test_shopping_app.data.ISalesRepository
import com.example.test_shopping_app.data.SaleService
import com.example.test_shopping_app.databinding.FragmentMainBinding
import com.example.test_shopping_app.domain.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewMainFragment: View
    private lateinit var data: List<Product>


    private val repository: ISalesRepository by inject()
    private lateinit var repositoryManual: ISalesRepository
    private lateinit var service: SaleService

    private val adapter by lazy {
        RecyclerAdapter(listOf())
    }

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


//        repositoryManual = SalesRepository(salesServiceInstance)

        binding.rec.adapter = adapter
        CoroutineScope(Dispatchers.IO).launch {
            data = getRequisition()
            requireActivity().runOnUiThread {
                adapter.updateData(data)
            }
        }
    }


    private suspend fun getRequisition(): List<Product> {
        return try {
            repository.fetchProducts()
        } catch (e: Exception) {
            listOf()
        }
    }
}