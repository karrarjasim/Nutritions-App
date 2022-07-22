package com.example.nutritionApp.ui

import com.example.nutritionApp.data.domain.Meal

interface MealInteractionListener {
    fun onMealClick(meal: Meal)
}