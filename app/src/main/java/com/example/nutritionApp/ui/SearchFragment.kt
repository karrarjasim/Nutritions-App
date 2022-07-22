package com.example.nutritionApp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nutritionApp.data.DataManager
import com.example.nutritionApp.data.domain.Meal
import com.example.nutritionApp.databinding.FragmentSearchBinding
import com.example.nutritionApp.interfaces.NavigationInterface

class SearchFragment : BaseFragment<FragmentSearchBinding>(), MealInteractionListener {

    override var logTag = "SearchFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate
    private lateinit var dataManager: DataManager
    lateinit var adapter: MealAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = arguments?.getSerializable("dataManager") as DataManager
        dataManager = data
        listener = context as NavigationInterface
    }


    override fun addCallBacks() {

        val mealsList = dataManager.searchHistoryList
        adapter = MealAdapter(mealsList, this@SearchFragment)
        binding.apply {
            recyclerViewAddedItems.adapter = adapter
            searchEditText.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {}

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {

                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                    val newData = dataManager.getFilteredMeals(s)
                    adapter.search(newData)
                    if (newData.isEmpty()){
                        binding.noDataLayout.visibility = View.VISIBLE
                    }
                }
            })
        }
    }

    companion object {

        fun newInstance(dataManager: DataManager): SearchFragment {
            return SearchFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("dataManager", dataManager)
                }
            }
        }
    }

    override fun onMealClick(meal: Meal) {
        dataManager.searchHistoryList.add(meal)
        val detailsFragment = DetailsFragment.newInstance(meal, dataManager)
        listener?.addFragment(detailsFragment)
    }

}