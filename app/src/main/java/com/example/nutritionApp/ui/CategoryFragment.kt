package com.example.nutritionApp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionApp.data.DataManager
import com.example.nutritionApp.data.domain.Meal
import com.example.nutritionApp.databinding.FragmentCategoryBinding
import com.example.nutritionApp.interfaces.NavigationInterface
import com.example.nutritionApp.util.Constants

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(), MealInteractionListener {

    override var logTag = "CategoryFragment"
    private lateinit var dataManager: DataManager

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate


    override fun onStart() {
        super.onStart()
        dataManager = arguments?.getSerializable(Constants.DATA_MANAGER_KEY) as DataManager

        val mealsList = arguments?.getParcelableArrayList<Meal>(Constants.CATEGORY_LIST_KEY)
        log(mealsList.toString())
        setText(mealsList)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as NavigationInterface
    }


    private fun setText(mealsList: ArrayList<Meal>?) {
        val list = requireNotNull(mealsList)
        binding.apply {
            RecyclerViewCatogaryItems.adapter = MealAdapter(list, this@CategoryFragment)
        }
    }


    override fun addCallBacks() {

    }

    override fun onMealClick(meal: Meal) {
        val detailsFragment = DetailsFragment.newInstance(meal, dataManager)
        listener?.addFragment(detailsFragment)
    }


    companion object {
        fun newInstance(proteinList: ArrayList<Meal>, dataManager: DataManager): CategoryFragment {
            return CategoryFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(Constants.CATEGORY_LIST_KEY, proteinList)
                    putSerializable(Constants.DATA_MANAGER_KEY, dataManager)

                }
            }
        }
    }

}