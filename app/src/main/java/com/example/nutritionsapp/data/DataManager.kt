package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.util.Constants

class DataManager {
    private val mealsList = mutableListOf<Meal>()

    private  val  meals = mutableListOf(
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

            water = "10 g" ,
            calcium = "10 g" ,
            fiber ="10 g" ,
            sugar ="10 g" ,
            cholesterol = "10 g" ,
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

    fun getMealByID(id: Int)  = mealsList.find { it.id ==id }


    fun getAllMeals(): MutableList<Meal> = mealsList

    fun addMeal(meal: Meal) {
        mealsList.add(meal)
    }


}