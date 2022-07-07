package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal

class DataManager {
    private val mealsList = mutableListOf<Meal>()

    fun addMeal(meal: Meal){
        mealsList.add(meal)
    }

    fun getAllMeals(): MutableList<Meal> = mealsList
}