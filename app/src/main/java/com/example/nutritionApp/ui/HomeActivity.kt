package com.example.nutritionApp.ui


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.nutritionApp.R
import com.example.nutritionApp.data.DataManager
import com.example.nutritionApp.databinding.ActivityHomeBinding
import com.example.nutritionApp.interfaces.NavigationInterface
import com.example.nutritionApp.util.Constants
import com.example.nutritionApp.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader


class HomeActivity : AppCompatActivity(), NavigationInterface {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var calorieFragment: CalorieFragment
    private val dataManager = DataManager()
    private var calories = 0
    private var weight = 0
    private var height = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calories = intent.getIntExtra(Constants.CALORIES_KEY, calories)
        weight = intent.getIntExtra(Constants.WEIGHT, weight)
        height = intent.getIntExtra(Constants.HEIGHT, height)
        if (savedInstanceState == null) {
            initSubView(calories)
        }
        addNavigationListener()

    }

    override fun onStart() {
        super.onStart()
        openFile()
    }

    private fun addNavigationListener() {
        binding.bottomAppBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.pageHome -> {
                    homeFragment = HomeFragment.newInstance(calories, weight, height, dataManager)
                    replaceFragment(homeFragment)
                    true
                }
                R.id.pageSearch -> {
                    searchFragment = SearchFragment.newInstance(dataManager)
                    replaceFragment(searchFragment)
                    true
                }
                R.id.pageCalorie -> {
                    calorieFragment = CalorieFragment.newInstanceFromHome(dataManager)
                    replaceFragment(calorieFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun initSubView(calories: Int) {
        homeFragment = HomeFragment.newInstance(calories, weight, height, dataManager)
        addFragment(homeFragment)
    }

    override fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.addToBackStack("fragment")
        transaction.commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun openFile() {
        val inputStream = this.assets?.open("nutrition.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val meal = parser.parse(it)
            dataManager.addMeal(meal)
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }


}