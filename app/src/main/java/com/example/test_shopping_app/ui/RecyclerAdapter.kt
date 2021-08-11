package com.example.test_shopping_app.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test_shopping_app.R
import com.example.test_shopping_app.domain.Product
import com.squareup.picasso.Picasso

class RecyclerAdapter(
    private val products : List<Product>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var imageProduct = view.findViewById<ImageView>(R.id.image_product)!!
        var txtName = view.findViewById<TextView>(R.id.txt_description)!!
        var txtPrice = view.findViewById<TextView>(R.id.txt_price)!!
        var btnBuy = view.findViewById<TextView>(R.id.btn_add_chart)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.layout_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = products[position].name
        holder.txtPrice.text = products[position].actual_price

        if (!products[position].image.isNullOrEmpty()){
            Picasso.get()
                .load(products[position].image)
                .into(holder.imageProduct)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}