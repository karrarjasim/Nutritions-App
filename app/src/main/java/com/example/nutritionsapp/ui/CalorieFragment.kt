package com.example.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalorieBinding


class CalorieFragment : BaseFragment<FragmentCalorieBinding>() {
    override var LOG_TAG = "CalorieFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalorieBinding
        get() = FragmentCalorieBinding::inflate

    private lateinit var dataManager : DataManager
    private lateinit var  addedItems: MutableList<Meal>
    private  var calculatedCalories: Int = 0
    private  var optimalCalories: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = arguments?.getSerializable("dataManager") as DataManager
        dataManager = data
         addedItems = dataManager.addedItems
         calculatedCalories = dataManager.calculateCaloriesForAddedMeals(addedItems)
         optimalCalories = dataManager.optimalCalories
    }



    override fun addCallBacks() {
        binding.apply {

            cardName.text = addedItems[0].name
            cardCalories.text = "${addedItems[0].calories} Cal"

            cardName2.text = addedItems[1].name
            cardCalories2.text = "${addedItems[1].calories} Cal"

            cardName3.text = addedItems[2].name
            cardCalories3.text = "${addedItems[2].calories} Cal"

            cardName4.text = addedItems[3].name
            cardCalories4.text = "${addedItems[3].calories} Cal"

            cardName5.text = addedItems[4].name
            cardCalories5.text = "${addedItems[4].calories} Cal"

            progressBar.setProgress((calculatedCalories * 100) / optimalCalories, true)
            caloriesCount.text = optimalCalories.toString()

            when {
                calculatedCalories > optimalCalories -> {
                    cardStatusDescription.text = "Items crosses your body optimal calories"
                    cardStatusFace.text = ":("
                }
                else -> {
                    cardStatusDescription.text = "Items is below your body optimal calories"
                    cardStatusFace.text = ":)"
                }
            }
        }
    }

    companion object {

        fun newInstance(dataManager: DataManager): CalorieFragment {
            return CalorieFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("dataManager", dataManager)
                }
            }
        }
    }

}