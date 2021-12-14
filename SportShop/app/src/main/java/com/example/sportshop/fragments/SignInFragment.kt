package com.example.sportshop.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sportshop.MainActivity
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentSignInBinding

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private lateinit var binding: FragmentSignInBinding

    companion object {
        fun newInstance() = SignInFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        @Suppress("DEPRECATION")
        requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_VISIBLE

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)

        binding.buttonSignInToUp.setOnClickListener {
            (activity as MainActivity).navigateToFragment(SignUpFragment.newInstance())
        }
        binding.buttonSignIn.setOnClickListener {
            (activity as MainActivity).navigateToFragment(CategoriesFragment.newInstance())
        }
    }
}
