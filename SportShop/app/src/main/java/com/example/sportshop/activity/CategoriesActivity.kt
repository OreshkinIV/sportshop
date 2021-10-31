package com.example.sportshop.activity

import android.app.Activity
import android.os.Bundle
import com.example.sportshop.databinding.ActivityCategoriesBinding

class CategoriesActivity: Activity() {
    private lateinit var binding: ActivityCategoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}