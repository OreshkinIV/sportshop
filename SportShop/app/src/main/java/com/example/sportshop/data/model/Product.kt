package com.example.sportshop.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val product_id: Int,
    val category: String,
    val product_name: String,
    val price: Int,
    val manufacturer: String,
    val description: String,
    val iconUrl: String
)
