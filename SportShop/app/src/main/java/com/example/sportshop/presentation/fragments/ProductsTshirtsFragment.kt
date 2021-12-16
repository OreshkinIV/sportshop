package com.example.sportshop.presentation.fragments

import com.example.sportshop.presentation.adapter.ProductAdapter
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportshop.presentation.activity.MainActivity
import com.example.sportshop.R
import com.example.sportshop.presentation.viewmodel.ScreenState
import com.example.sportshop.databinding.FragmentProductsBinding
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.ExperimentalSerializationApi
import com.example.sportshop.data.model.Product
import com.example.sportshop.presentation.viewmodel.TshirtsViewModel
import kotlinx.coroutines.flow.launchIn

class ProductsTshirtsFragment : Fragment(R.layout.fragment_products) {

    private lateinit var binding: FragmentProductsBinding
    private val viewModel by lazy { TshirtsViewModel(requireContext(), lifecycleScope) }

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
        if (savedInstanceState == null) {
            viewModel.loadData()
        }
        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.loadData() }
        binding.buttonRefresh.setOnClickListener { viewModel.loadData() }
        viewModel.screenState.onEach {
            when (it) {
                is ScreenState.DataLoaded -> {
                    setLoading(false)
                    setError(null)
                    setData(it.hats)
                }
                is ScreenState.Error -> {
                    setLoading(false)
                    setError(it.error)
                    setData(null)
                }
                is ScreenState.Loading -> {
                    setLoading(true)
                    setError(null)
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun setLoading(isLoading: Boolean) = with(binding) {
        progressBar.isVisible = isLoading && !rvProducts.isVisible
        swipeRefreshLayout.isRefreshing = isLoading && rvProducts.isVisible
    }

    private fun setData(tshirts: List<Product>?) = with(binding) {
        swipeRefreshLayout.isVisible = tshirts != null
        binding.rvProducts.layoutManager = LinearLayoutManager(context)
        rvProducts.adapter = ProductAdapter(
            tshirts ?: emptyList()
        ) { (id, category, name, price, manufacturer, description, image) ->
            (activity as MainActivity).navigateToFragment(
                ProductDetailsFragment.newInstance(
                    id, category, name, price, manufacturer, description, image
                )
            )
        }
    }

    private fun setError(message: String?) = with(binding) {
        errorLayout.isVisible = message != null
        tvError.text = message
    }
}
