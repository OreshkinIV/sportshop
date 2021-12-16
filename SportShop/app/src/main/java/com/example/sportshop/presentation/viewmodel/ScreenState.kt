package com.example.sportshop.presentation.viewmodel

import com.example.sportshop.data.model.Product

sealed class ScreenState {
    data class DataLoaded(val hats: List<Product>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}
