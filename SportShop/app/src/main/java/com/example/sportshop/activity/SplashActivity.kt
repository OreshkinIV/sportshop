package com.example.sportshop.activity

import android.app.Activity
import android.os.Bundle
import com.example.sportshop.databinding.ActivitySplashBinding

class SplashActivity : Activity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}