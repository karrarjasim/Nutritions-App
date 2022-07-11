package com.example.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.databinding.FragmentCalorieBinding


class CalorieFragment : BaseFragment<FragmentCalorieBinding>() {
    override var LOG_TAG = "CalorieFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalorieBinding
        get() = FragmentCalorieBinding::inflate

    private val addedItems: List<Meal> = DataManager().getAllAddedMeals()


    override fun addCallBacks() {
    }


}