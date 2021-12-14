package com.example.sportshop.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sportshop.MainActivity
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private lateinit var binding: FragmentCategoriesBinding

    companion object {
        fun newInstance() = CategoriesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoriesBinding.bind(view)

        binding.btHats.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProductsHatsFragment.newInstance())
        }
        binding.btSweatshirts.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProductsSweatshirtsFragment.newInstance())
        }
        binding.btTShirts.setOnClickListener {
            (activity as MainActivity).navigateToFragment(ProductsTshirtsFragment.newInstance())
        }
    }
}