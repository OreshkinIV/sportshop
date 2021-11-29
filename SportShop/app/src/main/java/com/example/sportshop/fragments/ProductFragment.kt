package com.example.sportshop.fragments

import adapter.OnProductClickListener
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentProductBinding
import model.Product

class ProductFragment : Fragment(R.layout.fragment_product) {

    private lateinit var binding: FragmentProductBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductBinding.bind(view)

    }
}

class ProductsVH(
    view: View,
    listener: OnProductClickListener
) : RecyclerView.ViewHolder(view) {
    private val ivCover = view.findViewById<ImageView>(R.id.iv_item)
    private val tvName = view.findViewById<TextView>(R.id.tv_title)
    private val tvDescription = view.findViewById<TextView>(R.id.tv_description)
    private val tvPrice = view.findViewById<TextView>(R.id.tv_price)

    private lateinit var product: Product

    init {
        view.setOnClickListener { listener(product) }
    }

    fun bind(product: Product) {
        this.product = product
        tvName.text = product.product_name
        tvDescription.text = product.description
        tvPrice.text = product.price.toString()

        Glide.with(itemView.context)
            .load(product.iconUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(ivCover)
    }
}