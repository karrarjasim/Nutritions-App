package com.example.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.databinding.FragmentCategoryBinding
import com.example.nutritionsapp.util.Constants

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(), MealInteractionListener {

    override var LOG_TAG = "CategoryFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate



    override fun onStart() {
        super.onStart()
        val mealsList = arguments?.getParcelableArrayList<Meal>(Constants.CATEGORY_LIST_KEY)
        log(mealsList.toString())
        setText(mealsList)



    }


    fun setText(mealsList: ArrayList<Meal>?){
        val list= requireNotNull(mealsList)
        binding.apply {
            RecyclerViewCatogaryItems.adapter=MealAdapter(list,this@CategoryFragment)
    }  }



    override fun addCallBacks(){

    }

        override fun onMealClick(meal: Meal) {
            val detailsFragment = DeatilsFragment.newInstance(meal)
            (activity as HomeActivity).addFragment(detailsFragment)
        }


    companion object {

        fun newInstance(proteinList: ArrayList<Meal>): CategoryFragment {
            return CategoryFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(Constants.CATEGORY_LIST_KEY, proteinList)
                }
            }
        }
    }

}