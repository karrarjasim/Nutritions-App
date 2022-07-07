package com.example.nutritionsapp.ui

import android.util.Log
import android.view.LayoutInflater
import com.example.nutritionsapp.databinding.ActivityMainBinding
import com.example.nutritionsapp.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader
import com.example.nutritionsapp.data.DataManager


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private fun openFile(){
        val inputStream = assets.open("nutrition.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val meal = parser.getAllMeals(it)
            val dataManger = DataManager()
            dataManger.addMeal(meal)
        }
    }

    override val LOG_TAG: String = "MAIN_ACTIVITY"

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate


    override fun setup() {
        openFile()
        val dataManger = DataManager()
        log(dataManger.getAllMeals())
    }

    override fun addCallbacks() {

    }
}