package com.example.nutritionsapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.databinding.FragmentCategoryBinding
import com.example.nutritionsapp.interfaces.NavigationInterface
import com.example.nutritionsapp.util.Constants

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(), MealInteractionListener {

    override var LOG_TAG = "CategoryFragment"
    lateinit var dataManager: DataManager

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate


    override fun onStart() {
        super.onStart()
        dataManager = arguments?.getSerializable(Constants.DATA_MANAGER_KEY) as DataManager

        val mealsList = arguments?.getSerializable(Constants.CATEGORY_LIST_KEY)
        log(mealsList.toString())
        setText(mealsList as ArrayList<Meal>?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as NavigationInterface
    }


    fun setText(mealsList: ArrayList<Meal>?) {
        val list = requireNotNull(mealsList)
        binding.apply {
            RecyclerViewCatogaryItems.adapter = MealAdapter(list, this@CategoryFragment)
        }
    }


    override fun addCallBacks() {

    }

    override fun onMealClick(meal: Meal) {
        val detailsFragment = DeatilsFragment.newInstance(meal, dataManager)
        listener?.addFragment(detailsFragment)
    }


    companion object {
        fun newInstance(proteinList: ArrayList<Meal>, dataManager: DataManager): CategoryFragment {
            return CategoryFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(Constants.CATEGORY_LIST_KEY, proteinList)
                    putSerializable(Constants.DATA_MANAGER_KEY, dataManager)

                }
            }
        }
    }

}