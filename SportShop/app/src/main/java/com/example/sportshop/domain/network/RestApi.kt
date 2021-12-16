package com.example.sportshop.domain.network

import com.example.sportshop.data.model.Product
import retrofit2.http.GET

interface RestApi {
    @GET("hats")
    suspend fun loadHats(): List<Product>

    @GET("tshirts")
    suspend fun loadTshirts(): List<Product>

    @GET("sweatshirts")
    suspend fun loadSweatshirts(): List<Product>
}