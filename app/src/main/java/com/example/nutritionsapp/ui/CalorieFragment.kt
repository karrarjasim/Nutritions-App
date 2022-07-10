package com.example.nutritionsapp.ui

import android.widget.ArrayAdapter
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalorieBinding
import com.github.mikephil.charting.charts.PieChart


class CalorieFragment : BaseFragment<FragmentCalorieBinding>(FragmentCalorieBinding::inflate) {
    override var LOG_TAG = "CalorieFragment"
    private val addedItems: List<Meal> = DataManager().getAllAddedMeals()


    override fun addCallBacks() {
    }


}