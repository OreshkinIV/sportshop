package com.example.sportshop.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Product(
    @PrimaryKey val product_id: Int,
    @ColumnInfo val category: String,
    @ColumnInfo val product_name: String,
    @ColumnInfo val price: Int,
    @ColumnInfo val manufacturer: String,
    @ColumnInfo val description: String,
    @ColumnInfo val iconUrl: String
)
