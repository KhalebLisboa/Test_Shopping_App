package com.example.test_shopping_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test_shopping_app.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {

    private lateinit var bind : FragmentInformationBinding
    private lateinit var viewInformation : View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentInformationBinding.inflate(inflater)
        viewInformation = bind.root
        return  viewInformation
    }
}