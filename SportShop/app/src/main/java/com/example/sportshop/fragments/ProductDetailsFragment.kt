package com.example.sportshop.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment(R.layout.fragment_product_details) {

    private lateinit var binding: FragmentProductDetailsBinding

    companion object {
        private const val KEY_ID = "KEY_ID"
        private const val KEY_CATEGORY = "KEY_CATEGORY"
        private const val KEY_NAME = "KEY_NAME"
        private const val KEY_PRICE = "KEY_PRICE"
        private const val KEY_MANUFACTURER = "KEY_MANUFACTURER"
        private const val KEY_DESCRIPTION = "KEY_DESCRIPTION"
        private const val KEY_IMAGE = "KEY_ICON_RES_ID"

        fun newInstance(
            id: Int,
            category: String,
            name: String,
            price: Int,
            manufacturer: String,
            description: String,
            image: String
        ): ProductDetailsFragment {
            val args = bundleOf(
                KEY_ID to id,
                KEY_CATEGORY to category,
                KEY_NAME to name,
                KEY_PRICE to price,
                KEY_MANUFACTURER to manufacturer,
                KEY_DESCRIPTION to description,
                KEY_IMAGE to image,

                )
            val fragment = ProductDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductDetailsBinding.bind(view)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val name = arguments?.getString(KEY_NAME)
        val description = arguments?.getString(KEY_DESCRIPTION)
        val image = arguments?.getString(KEY_IMAGE)
        val price = arguments?.getInt(KEY_PRICE)
        val manufacturer = arguments?.getString(KEY_MANUFACTURER)

        binding.tvManufacturerDetails.text = manufacturer
        binding.tvTitleDetails.text = name
        binding.tvDescriptionDetails.text = description
        val buttonText =
            getString(R.string.buy_for) + price.toString() + " " + getString(R.string.rub)
        binding.buttonBuy.text = buttonText
        context?.let {
            Glide.with(it)
                .load(image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivItemDetails)
        }
    }
}
