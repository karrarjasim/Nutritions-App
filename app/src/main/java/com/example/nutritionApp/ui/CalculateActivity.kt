package com.example.nutritionApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nutritionApp.R
import com.example.nutritionApp.databinding.ActivityCalculateBinding

class CalculateActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculateBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setTheme(R.style.splashScreenTheme)
        setContentView(binding.root)

    }

}