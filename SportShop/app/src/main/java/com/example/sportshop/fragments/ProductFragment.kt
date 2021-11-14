package com.example.sportshop.fragments

import adapter.OnProductClickListener
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentProductBinding
import model.Product

class ProductFragment : Fragment(R.layout.fragment_product) {

    private lateinit var binding: FragmentProductBinding

    companion object {
        private const val KEY_NAME = "KEY_NAME"
        private const val KEY_DESCRIPTION = "KEY_DESCRIPTION"
        private const val KEY_ICON_RES_ID = "KEY_ICON_RES_ID"

        fun newInstance(name: String, description: String, iconResId: Int): ProductFragment {
            val args = bundleOf(
                KEY_NAME to name,
                KEY_DESCRIPTION to description,
                KEY_ICON_RES_ID to iconResId
            )
            val fragment = ProductFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductBinding.bind(view)

        val name = arguments?.getString(KEY_NAME)
        val description = arguments?.getString(KEY_DESCRIPTION)
        val resId = arguments?.getInt(KEY_ICON_RES_ID)
        binding.tvItem.text = name
        binding.tv2Item.text = description
        if (resId != null) {
            binding.ivItem.setImageResource(resId)
        }
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