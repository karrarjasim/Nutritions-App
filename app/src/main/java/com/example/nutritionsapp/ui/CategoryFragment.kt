package com.example.nutritionsapp.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.databinding.FragmentCategoryBinding
import com.example.nutritionsapp.util.Constants

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    override var LOG_TAG = "CategoryFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onStart() {
        super.onStart()
        val mealsList = arguments?.getParcelableArrayList<Meal>(Constants.CATEGORY_LIST_KEY)
        log(mealsList.toString())
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

    override fun addCallBacks() {

    }
}