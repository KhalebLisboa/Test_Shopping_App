package com.example.test_shopping_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_shopping_app.R
import com.example.test_shopping_app.databinding.LayoutRecyclerItemBinding
import com.example.test_shopping_app.domain.Product
import com.example.test_shopping_app.domain.Products
import com.squareup.picasso.Picasso

class RecyclerAdapter(private var list: List<Product>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        return ViewHolder(
            LayoutRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    }


    fun updateData(list: List<Product>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list.get(position))
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val binding: LayoutRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(product: Product) {
            binding.txtDescription.text = product.name
           if(!product.image.isNullOrEmpty()){
               Picasso
                   .get()
                   .load(product.image)
                   .placeholder(R.drawable.ic_launcher_background)
                   .error(R.color.cardview_dark_background)
                   .into(binding.imageProduct)
           }
        }
    }
}