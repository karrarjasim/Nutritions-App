package com.example.nutritionsapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentSearchBinding
import com.example.nutritionsapp.util.Constants

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override var LOG_TAG = "SearchFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate
    private lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = arguments?.getSerializable("dataManager") as DataManager
        dataManager = data
    }

    override fun addCallBacks() {

        val mealsList = dataManager.addedMealsToBeCalculated

        binding.searchQuery.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @SuppressLint("SetTextI18n")
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isEmpty()) {
                    Toast.makeText(activity, "please type a word", Toast.LENGTH_LONG)
                        .show()
                }
                val filtered = mealsList.filter {
                    it.name.lowercase().contains(query.lowercase())
                }
                if (filtered.isNotEmpty()) {
                    filtered.forEach {
                        binding.tvC1.text = it.name
                        binding.tvCal1.text = "${filtered[0].calories} cal"
                    }
                    binding.searchLabel.text = "Search results"
                } else {
                    Toast.makeText(activity, "No result found", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })
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

}