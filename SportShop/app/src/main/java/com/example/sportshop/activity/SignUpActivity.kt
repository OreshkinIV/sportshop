package com.example.sportshop.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.sportshop.databinding.ActivitySignUpBinding

class SignUpActivity : Activity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}