package com.example.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.ItemMealBinding


class MealAdapter(private val addedMeals: List<Meal>) :
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val currentMeal = addedMeals[position]
        holder.binding.apply {
            cardName.text = currentMeal.name
            cardCalories.text = "${currentMeal.calories} cal"
        }
    }

    override fun getItemCount() = addedMeals.size

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMealBinding.bind(itemView)
    }
}