package com.example.sportshop.activity

import adapter.OnProductClickListener
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportshop.R
import model.Product
import com.example.sportshop.databinding.ItemProductBinding

class ProductActivity : Activity() {

    private lateinit var binding: ItemProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  binding.tvItem.text = intent.getStringExtra("KEY_NAME")
     // binding.tv2Item.text = intent.getStringExtra("KEY_DESCRIPTION")

    }
}

class ProductsVH(
    view: View,
    listener: OnProductClickListener
) : RecyclerView.ViewHolder(view) {
    private val ivCover = view.findViewById<ImageView>(R.id.iv_item)
    private val tvName = view.findViewById<TextView>(R.id.tv_item)
    private val tvDescription = view.findViewById<TextView>(R.id.tv2_item)

    private lateinit var product: Product

    init {
        view.setOnClickListener { listener(product) }
    }

    fun bind(product: Product) {
        this.product = product
        tvName.text = product.productName
        tvDescription.text = product.description
        ivCover.setImageResource(product.coverResId)
    }
}