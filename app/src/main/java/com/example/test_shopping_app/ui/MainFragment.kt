package com.example.test_shopping_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test_shopping_app.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private  lateinit var binding: FragmentMainBinding
    private lateinit var viewMainFragment : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        viewMainFragment = binding.root
        return viewMainFragment
    }
}