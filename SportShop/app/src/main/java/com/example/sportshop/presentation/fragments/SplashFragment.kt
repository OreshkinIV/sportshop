package com.example.sportshop.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.sportshop.presentation.activity.MainActivity
import com.example.sportshop.R
import com.example.sportshop.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            requireActivity().window.insetsController?.hide(WindowInsets.Type.statusBars())
            requireActivity().window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        } else {
            requireActivity().window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            requireActivity().window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        Handler(Looper.getMainLooper()).postDelayed({
            (activity as MainActivity).navigateToFragment(SignInFragment.newInstance())
            requireActivity().window.clearFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }, 2500)
    }
}