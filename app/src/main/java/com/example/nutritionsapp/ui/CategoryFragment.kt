package com.example.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.databinding.FragmentCategoryBinding

class CategoryFragment: BaseFragment<FragmentCategoryBinding>() {
    override var LOG_TAG = "CategoryFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate



    var list=DataManager().mlist
    override fun addCallBacks() {
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


    }


}