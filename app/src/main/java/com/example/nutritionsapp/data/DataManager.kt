package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal

class DataManager {
    private val mealsList = mutableListOf<Meal>()

    private val addedItems = mutableListOf(
        Meal(
            calories = "200",
            name = "Pizza",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
        ),
        Meal(
            calories = "150",
            name = "Burger",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
        ),
        Meal(
            calories = "100",
            name = "Chips",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
        ),
        Meal(
            calories = "50",
            name = "Potatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
        ),
        Meal(
            calories = "50",
            name = "Tomatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
        )
    )


    fun getAllAddedMeals(): MutableList<Meal> = addedItems

    fun addMeal(meal: Meal) {
        mealsList.add(meal)
    }

    fun getAllMeals(): MutableList<Meal> = mealsList
}