package com.example.sportshop.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object NetworkService {
    @ExperimentalSerializationApi
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://demo6821591.mockable.io/")
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .build()
    @ExperimentalSerializationApi
    private val restApi = retrofit.create(RestApi::class.java)
    @ExperimentalSerializationApi
    suspend fun loadHats() = restApi.loadHats()
    @ExperimentalSerializationApi
    suspend fun loadTshirts() = restApi.loadTshirts()
    @ExperimentalSerializationApi
    suspend fun loadSweatshirts() = restApi.loadSweatshirts()


}