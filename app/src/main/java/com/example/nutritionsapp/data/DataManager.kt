package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal

class DataManager {
    private val mealsList = mutableListOf<Meal>()

     val addedItems = mutableListOf<Meal>(
        Meal(
            calories = "200",
            name = "Pizza",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            vitaminD = "10",
            carb = "10",
            fiber = "10",
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
            vitaminD = "10",
            carb = "10",
            fiber = "10",
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
            vitaminD = "10",
            carb = "10",
            fiber = "10",
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
            vitaminD = "10",
            carb = "10",
            fiber = "10",
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
            vitaminD = "10",
            carb = "10",
            fiber = "10",
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
             vitaminD = "10",
             carb = "10",
             fiber = "10",
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
             vitaminD = "10",
             carb = "10",
             fiber = "10",
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
             vitaminD = "10",
             carb = "10",
             fiber = "10",
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
             vitaminD = "10",
             carb = "10",
             fiber = "10",
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
             vitaminD = "10",
             carb = "10",
             fiber = "10",
         ),

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


    fun addMeal(meal: Meal) {
        mealsList.add(meal)
    }

    fun getAllMeals(): MutableList<Meal> = mealsList


    fun getHighProteinMeals( size: Int = 10): MutableList<Meal> {
        mealsList.let { it ->
            return it.sortedByDescending { it.protein }.take(size).toMutableList()
        }
    }

    fun getTopMealsContainsVitamin(size: Int = 10): MutableList<Meal> {
        mealsList.let { it ->
            return it.sortedByDescending { it.vitaminD }.take(size).toMutableList()
        }
    }

    fun getTopMealsContainsCarb(size: Int = 10): MutableList<Meal> {
        mealsList.let { it ->
            return it.sortedByDescending { it.carb }.take(size).toMutableList()
        }
    }

    fun getTopMealsContainsFiber(size: Int = 10): MutableList<Meal> {
        mealsList.let { it ->
            return it.sortedByDescending { it.fiber }.take(size).toMutableList()
        }
    }
}