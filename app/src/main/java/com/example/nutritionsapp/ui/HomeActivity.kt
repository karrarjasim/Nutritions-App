package com.example.nutritionsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.R
import com.example.nutritionsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val calorieFragment = CalorieFragment()
    private val calculateFragment = CalculateFragment()
    private val categoryFragment = CategoryFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSubView()
        addNavigationListener()
    }

    private fun addNavigationListener() {
        binding.bottomAppBar.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.pageHome -> {
                        replaceFragment(categoryFragment)
                        true
                    }
                    R.id.pageSearch -> {
                        replaceFragment(searchFragment)
                        true
                    }
                    R.id.pageCalorie -> {
                        replaceFragment(calorieFragment)
                        true
                    }
                    else -> false
                }
        }
    }

    private fun initSubView(){
        addFragment(homeFragment);
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