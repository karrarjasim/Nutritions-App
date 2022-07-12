package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal

class DataManager {
    private val mealsList = mutableListOf<Meal>()

    val  meals = mutableListOf<Meal>(
        Meal(
            id = 0,
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
            id =1,
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
            id = 2,
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
            id = 3,
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
            id = 4,
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

    private val addedItems = mutableListOf(
        Meal(
            id = 0,
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
            id =1,
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
            id = 2,
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
            id = 3,
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
            id = 4,
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

    private var calories: Int = 0
    var optimalCalories: Int = 2000
    var calculatedCalories: Int = 0
    var progressBarPercentage: Int = 0

    fun getAllAddedMeals(): MutableList<Meal> {
        addedItems.forEach {
            calories += it.calories.toInt()
        }
        calculatedCalories = calories
        println("calories = $calories")
        progressBarPercentage = (calories * 100) / optimalCalories
        calories = 0
        return addedItems
    }

    fun getMealByID(id: Int)  =  mealsList.filter { it.id ==id } as Meal


    fun addMeal(meal: Meal) {
        mealsList.add(meal)
    }

    fun getAllMeals(): MutableList<Meal> = mealsList
}