package com.example.nutritionsapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override var LOG_TAG = "SearchFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun addCallBacks() {
        val dataManager = DataManager()
        val mealsList = dataManager.addedItems

        binding.searchQuery.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @SuppressLint("SetTextI18n")
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isEmpty()){
                    Toast.makeText(activity, "please type a word", Toast.LENGTH_LONG)
                        .show()
                }
                val filtered = mealsList.filter{
                    it.name.lowercase().contains(query.lowercase())
                }
                if (filtered.isNotEmpty()){
                    filtered.forEach {
                        binding.tvC1.text = it.name
                        binding.tvCal1.text="${filtered[0].calories} cal"
                    }
                    binding.searchLabel.text ="Search results"
                }else{
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
}