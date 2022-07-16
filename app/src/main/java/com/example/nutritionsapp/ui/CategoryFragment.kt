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
        binding.textView1.text = list[0].name
        binding.textViewCal1.text="${list[0].calories} cal"

        binding.textView2.text = list[1].name
        binding.textViewCal2.text="${list[1].calories} cal"

        binding.textView3.text = list[2].name
        binding.textViewCal3.text="${list[2].calories} cal"

        binding.textView4.text=list[3].name
        binding.textViewCal4.text="${list[3].calories} cal"

        binding.textView5.text=list[4].name
        binding.textViewCal5.text="${list[4].calories} cal"

        binding.textView6.text=list[5].name
        binding.textViewCal6.text="${list[5].calories} cal"

        binding.textView7.text=list[6].name
        binding.textViewCal7.text="${list[6].calories} cal"

        binding.textView8.text=list[7].name
        binding.textViewCal8.text="${list[7].calories} cal"

        binding.textView9.text=list[8].name
        binding.textViewCal9.text="${list[8].calories} cal"

        binding.textView9.text=list[9].name
        binding.textViewCal9.text="${list[9].calories} cal"



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

    }

    override fun addCallBacks(){

    }

    fun openDetailsFragment(meal:Meal?){
        val detylsFragment = meal?.let { DeatilsFragment.newInstance(it) }
        detylsFragment?.let { (activity as HomeActivity).addFragment(it) }
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