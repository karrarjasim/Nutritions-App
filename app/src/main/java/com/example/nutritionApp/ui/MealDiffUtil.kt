package com.example.nutritionApp.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.nutritionApp.data.domain.Meal

class MealDiffUtil(private val oldMealsList: List<Meal>, private val newMealsList: List<Meal>): DiffUtil.Callback() {

    override fun getOldListSize() =  oldMealsList.size

    override fun getNewListSize() = newMealsList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMealsList[oldItemPosition].name == newMealsList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}