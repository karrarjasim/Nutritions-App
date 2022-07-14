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
            mealslist?.get(0)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card2.setOnClickListener() {
            mealslist?.get(1)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card3.setOnClickListener() {
            mealslist?.get(2)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card4.setOnClickListener() {
            mealslist?.get(3)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card5.setOnClickListener() {
            mealslist?.get(4)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card6.setOnClickListener() {
            mealslist?.get(5)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card7.setOnClickListener() {
            mealslist?.get(6)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card8.setOnClickListener() {
            mealslist?.get(7)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card9.setOnClickListener() {
            mealslist?.get(8)?.let { it1 -> openDetailsFragment(it1.id) }
        }

        binding.card10.setOnClickListener() {
            mealslist?.get(9)?.let { it1 -> openDetailsFragment(it1.id) }
        }
    }

    override fun addCallBacks(){

    }

    fun openDetailsFragment(id: Int){
        val detylsFragment =DeatilsFragment.newInstance(id)
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