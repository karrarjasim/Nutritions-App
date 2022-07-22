package com.example.nutritionApp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionApp.R
import com.example.nutritionApp.data.domain.Meal
import com.example.nutritionApp.databinding.ItemMealBinding


class MealAdapter(
    private var addedMeals: List<Meal>,
    private val listener: MealInteractionListener
) :
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    fun search(resultMeals: List<Meal>) {
        val diffResult = DiffUtil.calculateDiff(MealDiffUtil(addedMeals, resultMeals))
        addedMeals = resultMeals
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val currentMeal = addedMeals[position]
        holder.binding.apply {
            cardName.text = currentMeal.name
            cardCalories.text = "${currentMeal.calories} cal"
            singleItemCard1.setOnClickListener { listener.onMealClick(currentMeal) }
            root.setOnClickListener {
                listener.onMealClick(currentMeal)
            }
        }
    }

    override fun getItemCount() = addedMeals.size

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMealBinding.bind(itemView)
    }
}