package com.example.nutritionsapp.ui

import com.example.nutritionsapp.data.domain.Meal

interface MealInteractionListener {
    fun onMealClick(meal: Meal)
}