package com.example.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalorieBinding


class CalorieFragment : BaseFragment<FragmentCalorieBinding>() {
    override var LOG_TAG = "CalorieFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalorieBinding
        get() = FragmentCalorieBinding::inflate

    private val dataManager = DataManager()
    private val addedItems: List<Meal> = dataManager.getAllAddedMeals()


    override fun addCallBacks() {
        binding.apply {
            cardName.text = addedItems[0].name
            cardCalories.text = addedItems[0].calories
            cardName2.text = addedItems[1].name
            cardCalories2.text = addedItems[1].calories
            cardName3.text = addedItems[2].name
            cardCalories3.text = addedItems[2].calories
            cardName4.text = addedItems[3].name
            cardCalories4.text = addedItems[3].calories
            cardName5.text = addedItems[4].name
            cardCalories5.text = addedItems[4].calories
            progressBar.setProgress(dataManager.progressBarPercentage, true)
            caloriesCount.text = dataManager.optimalCalories.toString()
            if (dataManager.calculatedCalories > dataManager.optimalCalories) {
                cardStatusDescription.text = "Items crosses your body optimal calories"
                cardStatusFace.text = ":("
            } else {
                cardStatusDescription.text = "Items is below your body optimal calories"
                cardStatusFace.text = ":)"
            }
        }
    }


}