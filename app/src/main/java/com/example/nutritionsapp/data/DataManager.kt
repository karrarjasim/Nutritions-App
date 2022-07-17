package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal
import java.io.Serializable

class DataManager : Serializable {
    val mealsList = mutableListOf<Meal>()

    val addedItems = mutableListOf(
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
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        ),
        Meal(
            id = 1,
            calories = "150",
            name = "Burger",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
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
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
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
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
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
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        ),
        Meal(
            id = 5,
            calories = "50",
            name = "Tomatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        ),
        Meal(
            id = 6,
            calories = "50",
            name = "Tomatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        ),
        Meal(
            id = 7,
            calories = "50",
            name = "Tomatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        ),
        Meal(
            id = 8,
            calories = "50",
            name = "Tomatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        ),
        Meal(
            id = 9,
            calories = "50",
            name = "Tomatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        ),
        Meal(
            id = 10,
            calories = "50",
            name = "Tomatoes",
            caffeine = "10",
            fat = "10",
            protein = "10",
            saturatedFat = "10",
            servingSize = "100",
            totalFat = "10",
            water = "10 g",
            calcium = "10 g",
            fiber = "10 g",
            sugar = "10 g",
            cholesterol = "10 g",
            carb = "10 g",
            vitaminD = "10 g",
        )


    )

    var optimalCalories: Int = 2000

    fun calculateCaloriesForAddedMeals(addedItems: List<Meal>): Int {
        var calories = 0
        addedItems.forEach {
            calories += it.calories.toInt()
        }
        return calories
    }

    fun getMealByID(id: Int) = mealsList.find { it.id == id }


    fun addMeal(meal: Meal) {
        mealsList.add(meal)
    }

    fun getHighProteinMeals(addedItems: List<Meal>, size: Int = 10): MutableList<Meal> {
        addedItems.let { it ->
            return it.sortedByDescending { it.protein }.take(size).toMutableList()
        }
    }

    fun getTopMealsContainsVitamin(addedItems: List<Meal>, size: Int = 10): MutableList<Meal> {
        addedItems.let { it ->
            return it.sortedByDescending { it.vitaminD }.take(size).toMutableList()
        }
    }

    fun getTopMealsContainsCarb(addedItems: List<Meal>, size: Int = 10): MutableList<Meal> {
        addedItems.let { it ->
            return it.sortedByDescending { it.carb }.take(size).toMutableList()
        }
    }

    fun getTopMealsContainsFiber(addedItems: List<Meal>, size: Int = 10): MutableList<Meal> {
        addedItems.let { it ->
            return it.sortedByDescending { it.fiber }.take(size).toMutableList()
        }
    }

}