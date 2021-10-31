package com.example.sportshop.activity

import adapter.ProductAdapter
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportshop.R
import data.DataSource.products

class ProductsActivity : Activity() {

    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)

        rvProducts.layoutManager = LinearLayoutManager(this)
        rvProducts.adapter = ProductAdapter(products) { (name, description,iconResId) ->
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra(KEY_NAME, name)
            intent.putExtra(KEY_DESCRIPTION, description)
            intent.putExtra(KEY_ICON_RES_ID, iconResId)
            startActivity(intent)
        }
    }

}
