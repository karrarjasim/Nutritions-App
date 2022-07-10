package com.example.nutritionsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.R
import com.example.nutritionsapp.databinding.ActivityCalculateBinding
import com.example.nutritionsapp.databinding.ActivityHomeBinding

class CalculateActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculateBinding
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val calorieFragment = CalorieFragment()
    private val calculateFragment = CalculateFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSubView()
        addCallback()
    }

    private fun addCallback() {
    }

    private fun initSubView(){
        addFragment(calculateFragment);
    }
    private fun addFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}