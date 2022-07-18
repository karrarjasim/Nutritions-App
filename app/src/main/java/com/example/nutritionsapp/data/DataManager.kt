package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.ui.MealAdapter
import java.io.Serializable

class DataManager : Serializable {
    val mealsList = mutableListOf<Meal>()

    val addedMealsToBeCalculated = mutableListOf<Meal>()

    fun addItemToAddedItems(meal: Meal) {
        addedMealsToBeCalculated.add(meal)
    }

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

    fun getFilteredMeals(name: CharSequence): List<Meal>{
        return mealsList.filter {
            it.name.contains(name)
        }
    }

}