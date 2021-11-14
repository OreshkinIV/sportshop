package com.example.sportshop.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sportshop.MainActivity
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up)  {

    private lateinit var binding: FragmentSignUpBinding

    companion object {
        fun newInstance() = SignUpFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)

        binding.buttonSignUp.setOnClickListener {
            (activity as MainActivity).navigateToFragment(SignInFragment.newInstance())
        }
    }
}