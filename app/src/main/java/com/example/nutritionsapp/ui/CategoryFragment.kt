package com.example.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.databinding.FragmentCategoryBinding
import com.example.nutritionsapp.util.Constants

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    override var LOG_TAG = "CategoryFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate



    override fun onStart() {
        super.onStart()
        val mealsList = arguments?.getParcelableArrayList<Meal>(Constants.CATEGORY_LIST_KEY)
        log(mealsList.toString())
        setText(mealsList)
        callBacks(mealsList)


    }


    fun setText(mealsList: ArrayList<Meal>?){
        val list= requireNotNull(mealsList)
        binding.tvC1.text = list[0].name
        binding.tvCal1.text="${list[0].calories} cal"
        binding.tvC2.text = list[1].name
        binding.tvCal2.text="${list[1].calories} cal"
        binding.tvC3.text = list[2].name
        binding.tvCal3.text="${list[2].calories} cal"
        binding.tvC4.text=list[3].name
        binding.tvCal4.text="${list[3].calories} cal"
        binding.tvC5.text=list[4].name
        binding.tvCal5.text="${list[4].calories} cal"
        binding.tvC6.text=list[5].name
        binding.tvCal6.text="${list[5].calories} cal"
        binding.tvC7.text=list[6].name
        binding.tvCal7.text="${list[6].calories} cal"
        binding.tvC8.text=list[7].name
        binding.tvCal8.text="${list[7].calories} cal"
        binding.tvC9.text=list[8].name
        binding.tvCal9.text="${list[8].calories} cal"
        binding.tvCal10.text="${list[9].calories} cal"
    }

    fun callBacks(mealslist: ArrayList<Meal>?) {
        binding.card1.setOnClickListener() {
            openDetailsFragment(mealslist?.get(0))
        }

        binding.card2.setOnClickListener() {
            openDetailsFragment(mealslist?.get(1))
        }

        binding.card3.setOnClickListener() {
            openDetailsFragment(mealslist?.get(2))
        }

        binding.card4.setOnClickListener() {
            openDetailsFragment(mealslist?.get(3))
        }

        binding.card5.setOnClickListener() {
            openDetailsFragment(mealslist?.get(4))
        }

        binding.card6.setOnClickListener() {
            openDetailsFragment(mealslist?.get(5))
        }

        binding.card7.setOnClickListener() {
            openDetailsFragment(mealslist?.get(6))
        }

        binding.card8.setOnClickListener() {
            openDetailsFragment(mealslist?.get(7))
        }

        binding.card9.setOnClickListener() {
            openDetailsFragment(mealslist?.get(8))
        }

        binding.card10.setOnClickListener() {
            openDetailsFragment(mealslist?.get(9))
        }
    }

    override fun addCallBacks(){

    }

    fun openDetailsFragment(meal:Meal?){
        val detylsFragment =DeatilsFragment.newInstance(meal!!)
        (activity as HomeActivity).addFragment(detylsFragment)
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