package model

import androidx.annotation.DrawableRes

data class Product(
    val productName: String,
    val description: String,
    @DrawableRes
    val coverResId: Int,
    val category: String,
    val price: Int,
    val manufacturer: Manufacturer
)
