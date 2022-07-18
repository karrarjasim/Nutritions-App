package com.example.nutritionsapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalorieBinding
import com.example.nutritionsapp.util.Constants


class CalorieFragment : BaseFragment<FragmentCalorieBinding>(), MealInteractionListener {
    override var LOG_TAG = "CalorieFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalorieBinding
        get() = FragmentCalorieBinding::inflate

    private lateinit var dataManager: DataManager
    private lateinit var addedItems: MutableList<Meal>
    lateinit var adapter: MealAdapter

    private var calculatedCalories: Int = 0
    private var optimalCalories: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = arguments?.getSerializable(Constants.DATA_MANAGER_KEY) as DataManager
        dataManager = data
        addedItems = dataManager.addedMealsToBeCalculated
        calculatedCalories = dataManager.calculateCaloriesForAddedMeals(addedItems)
        optimalCalories = dataManager.optimalCalories

    }


    override fun addCallBacks() {
        binding.apply {
            adapter = MealAdapter(addedItems, this@CalorieFragment)
            recyclerViewAddedItems.adapter = adapter
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


    override fun onMealClick(meal: Meal) {
        val detailsFragment = DeatilsFragment.newInstance(meal, dataManager)
        (activity as HomeActivity).addFragment(detailsFragment)
    }


    companion object {

//        fun newInstance(listOfMeals: ArrayList<Meal>): CalorieFragment {
//            return CalorieFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelableArrayList(Constants.MEAL_KEY, listOfMeals)
//                }
//            }
//        }

        fun newInstanceFromHome(dataManager: DataManager): CalorieFragment {
            return CalorieFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(Constants.DATA_MANAGER_KEY, dataManager)
                }
            }
        }

    }
}