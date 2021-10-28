package model

import androidx.annotation.DrawableRes

data class Product(
    val productName: String,
    val productId: Int,
    val category: String,
    val price: Int,
    val manufacturer: Manufacturer,
    @DrawableRes
    val coverResId: Int,
    val description: String
)
