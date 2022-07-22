package com.example.nutritionApp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionApp.data.DataManager
import com.example.nutritionApp.data.domain.Meal
import com.example.nutritionApp.databinding.FragmentCalorieBinding
import com.example.nutritionApp.interfaces.NavigationInterface
import com.example.nutritionApp.util.Constants


class CalorieFragment : BaseFragment<FragmentCalorieBinding>(), MealInteractionListener {
    override var logTag = "CalorieFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalorieBinding
        get() = FragmentCalorieBinding::inflate

    private lateinit var dataManager: DataManager
    private lateinit var addedItems: MutableList<Meal>
    private lateinit var adapter: MealAdapter

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
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as NavigationInterface
    }


    override fun addCallBacks() {
        binding.apply {
            adapter = MealAdapter(addedItems, this@CalorieFragment)
            recyclerViewAddedItems.adapter = adapter
            progressBar.setProgress((calculatedCalories * 100) / optimalCalories, true)
            caloriesCount.text = "${(calculatedCalories * 100) / optimalCalories}%"
            when {
                calculatedCalories > optimalCalories -> {
                    cardStatusDescription.text = "Items crosses your body optimal calories"
//                    cardStatusFace.text = ":("
                }
                else -> {
                    cardStatusDescription.text = "Items is below your body optimal calories"
//                    cardStatusFace.text = ":)"
                }
            }
        }
    }


    override fun onMealClick(meal: Meal) {
        val detailsFragment = DetailsFragment.newInstance(meal, dataManager)
        listener?.addFragment(detailsFragment)
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