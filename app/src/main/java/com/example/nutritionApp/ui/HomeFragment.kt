package com.example.nutritionApp.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionApp.data.DataManager
import com.example.nutritionApp.data.domain.Meal
import com.example.nutritionApp.databinding.FragmentHomeBinding
import com.example.nutritionApp.interfaces.NavigationInterface
import com.example.nutritionApp.util.Constants
import com.example.nutritionApp.util.PrefsUtil
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override var logTag = "HOME_FRAGMENT"
    private lateinit var dataManager: DataManager
    private lateinit var mealsList: MutableList<Meal>


    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun addCallBacks() {
        binding.proteinMealCard.setOnClickListener {
            val proteinList = dataManager.getHighProteinMeals(mealsList)
            log(proteinList)
            openCategoryDetails(proteinList)
        }

        binding.vitaminD3MealCard.setOnClickListener {
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
        val height =
            if (PrefsUtil.heightInform != null || PrefsUtil.heightInform != 0) PrefsUtil.heightInform else arguments?.getInt(
                Constants.HEIGHT
            )
        val weight =
            if (PrefsUtil.weightInform != null || PrefsUtil.weightInform != 0) PrefsUtil.weightInform else arguments?.getInt(
                Constants.WEIGHT
            )
        val calorie =
            if (PrefsUtil.optimalCaloriesInform != null || PrefsUtil.optimalCaloriesInform != 0) PrefsUtil.optimalCaloriesInform else arguments?.getInt(
                Constants.CALORIES_KEY
            )

        setupPieChart(calorie.toString())
        loadPieChartData()
        dataManager = arguments?.getSerializable(Constants.DATA_MANAGER_KEY) as DataManager
        mealsList = dataManager.mealsList
        binding.weightLabel.text = weight.toString()
        binding.hightLabel.text = height.toString()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as NavigationInterface
    }

    private fun setupPieChart(calories: String) {
        binding.pieChart.apply {
            centerText = "\n$calories"
            setCenterTextSize(18F)
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
            add(rgb("#005F73")) // blue
            add(rgb("#73C080")) // red
            add(rgb("#C8ECE2")) // yellow
        }

        val dataSet = PieDataSet(entries, "")
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


    private fun openCategoryDetails(mealsList: MutableList<Meal>) {
        val categoryFragment =
            CategoryFragment.newInstance(mealsList as ArrayList<Meal>, dataManager)
        listener?.addFragment(categoryFragment)
    }


    companion object {

        fun newInstance(
            calorie: Int,
            weight: Int,
            height: Int,
            dataManager: DataManager
        ): HomeFragment {
            return HomeFragment().apply {
                arguments = Bundle().apply {
                    putInt(Constants.CALORIES_KEY, calorie)
                    putInt(Constants.WEIGHT, weight)
                    putInt(Constants.HEIGHT, height)
                    putSerializable(Constants.DATA_MANAGER_KEY, dataManager)
                }
            }
        }
    }

}