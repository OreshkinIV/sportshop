package com.example.sportshop.fragments

import adapter.ProductAdapter
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportshop.MainActivity
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentProductsBinding
import com.example.sportshop.network.NetworkService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi

class ProductsTshirtsFragment : Fragment(R.layout.fragment_products) {

    private lateinit var binding: FragmentProductsBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        binding.progressBar.visibility = View.GONE
        binding.rvProducts.adapter =
            ProductAdapter(listOf()) {}
        binding.swipeRefreshLayout.isRefreshing = false
        Snackbar.make(
            requireView(),
            getString(R.string.error),
            Snackbar.LENGTH_SHORT
        ).setBackgroundTint(Color.parseColor("#ED4337"))
            .setActionTextColor(Color.parseColor("#FFFFFF"))
            .show()
    }

    private val scope =
        CoroutineScope(Dispatchers.Main + SupervisorJob() + coroutineExceptionHandler)

    companion object {
        fun newInstance() = ProductsTshirtsFragment()
    }

    @ExperimentalSerializationApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            (activity as MainActivity).navigateToFragment(
                CategoriesFragment.newInstance()
            )
        }
        loadTshirts()
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = true
            loadTshirts()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    @ExperimentalSerializationApi
    private fun loadTshirts() {
        scope.launch {
            val tshirts = NetworkService.loadTshirts()
            binding.rvProducts.layoutManager = LinearLayoutManager(context)
            binding.rvProducts.adapter =
                ProductAdapter(tshirts) { (id, category, name, price, manufacturer, description, image) ->
                    (activity as MainActivity).navigateToFragment(
                        ProductDetailsFragment.newInstance(
                            id, category, name, price, manufacturer, description, image
                        )
                    )
                }
            binding.progressBar.visibility = View.GONE
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}
