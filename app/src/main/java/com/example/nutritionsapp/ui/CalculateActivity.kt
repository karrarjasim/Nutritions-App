package com.example.nutritionsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.R
import com.example.nutritionsapp.databinding.ActivityCalculateBinding

class CalculateActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculateBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setTheme(R.style.splashScreenTheme)
        setContentView(binding.root)

    }

}