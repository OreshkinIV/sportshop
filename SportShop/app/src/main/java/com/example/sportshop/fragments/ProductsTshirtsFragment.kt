package com.example.sportshop.fragments

import adapter.ProductAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportshop.MainActivity
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentProductsBinding
import data.DataSource.products_t_shirts

class ProductsTshirtsFragment : Fragment(R.layout.fragment_products) {

    private lateinit var binding: FragmentProductsBinding

    companion object {
        fun newInstance() = ProductsTshirtsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {   (activity as MainActivity).navigateToFragment(CategoriesFragment.newInstance())  }

       binding.rvProducts.layoutManager = LinearLayoutManager(context)
         binding.rvProducts.adapter = ProductAdapter(products_t_shirts) { (name,description,resId) ->
             (activity as MainActivity).navigateToFragment(ProductFragment.newInstance(name,description,resId))

        }
    }
}
