package com.example.sportshop.data.model

data class OrderItems(
    val orderId: Int,
    val productId: Int,
    val quantity: Int,
    val address: String
)
