package com.example.nutritionsapp.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentHomeBinding
import com.example.nutritionsapp.util.CsvParser
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb
import java.io.BufferedReader
import java.io.InputStreamReader


class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override var LOG_TAG = "HOME_FRAGMENT"
    val dataManager = DataManager()
    private val mealsList: List<Meal> = dataManager.mealsList

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun addCallBacks() {
        binding.proteinMealCard.setOnClickListener{
            val proteinList = dataManager.getHighProteinMeals(mealsList)
            log(proteinList)
            openCategoryDetails(proteinList)
        }

        binding.vitaminD3MealCard.setOnClickListener{
            val vitaminsList = dataManager.getTopMealsContainsVitamin(mealsList)
            openCategoryDetails(vitaminsList)
        }

        binding.highCarbMealCard.setOnClickListener {
            val carbList = dataManager.getTopMealsContainsCarb(mealsList)
            openCategoryDetails(carbList)
        }

        binding.fiberMealCard.setOnClickListener {
            val fiberList = dataManager.getTopMealsContainsFiber(mealsList)
            openCategoryDetails(fiberList)
        }
    }

    override fun onStart() {
        super.onStart()
        val calorie = arguments?.getInt("calorie")
        setupPieChart(calorie.toString())
        loadPieChartData()
        openFile()

    }

    private fun setupPieChart(calories: String) {
        binding.pieChart.apply {
            centerText = "calories\n $calories"
            setCenterTextSize(12F)
            setUsePercentValues(true)
            description.isEnabled = false
            legend.isEnabled = false
        }
    }

    private fun loadPieChartData() {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.apply {
            add(PieEntry(0.5f))
            add(PieEntry(0.3f))
            add(PieEntry(0.2f))
        }

        val colors: ArrayList<Int> = ArrayList()
        colors.apply {
            add(rgb("#0064E5"))
            add(rgb("#FF6752"))
            add(rgb("#FAB131"))
        }

        val dataSet = PieDataSet(entries,"")
        dataSet.colors = colors
        val data = PieData(dataSet)
        binding.pieChart.data = data
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(binding.pieChart))
        data.setValueTextSize(8f)
        data.setValueTextColor(Color.BLACK)
        binding.pieChart.invalidate()
        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)
    }

    private fun openFile(){
        val inputStream = activity?.assets?.open("nutrition.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val meal = parser.parse(it)
            dataManager.addMeal(meal)
        }
    }

    private fun openCategoryDetails(mealsList: MutableList<Meal>){
        val categoryFragment = CategoryFragment.newInstance(mealsList as ArrayList<Meal>)
        (activity as HomeActivity).addFragment(categoryFragment)
    }

    companion object {

        fun newInstance(calorie: Int): HomeFragment {
            return HomeFragment().apply {
                arguments = Bundle().apply {
                    putInt("calorie", calorie)
                }
            }
        }
    }

}