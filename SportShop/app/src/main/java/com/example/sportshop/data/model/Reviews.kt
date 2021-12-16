package com.example.sportshop.data.model

import java.util.Date

data class Reviews(
    val user: User,
    val text: String,
    val date: Date
)
