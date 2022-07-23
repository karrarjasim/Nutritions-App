package com.example.nutritionApp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.nutritionApp.R
import com.example.nutritionApp.data.DataManager
import com.example.nutritionApp.data.domain.Meal
import com.example.nutritionApp.databinding.FragmentDetailsBinding
import com.example.nutritionApp.util.Constants
import com.example.nutritionApp.util.toFloatNumber
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb


class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override var logTag = Constants.DETAILS_KEY
    private lateinit var dataManager: DataManager
    var meal: Meal? = null
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun onStart() {
        super.onStart()
        meal = requireNotNull(arguments?.getParcelable(Constants.ID_KEY))
        /// meal comes when we click on a meal in the list in the added meals in calories fragment
        dataManager = arguments?.getSerializable(Constants.DATA_MANAGER_KEY) as DataManager

        if (dataManager.addedMealsToBeCalculated.contains(meal)) {
            binding.buttonDialy.text = getString(R.string.done)
            binding.buttonDialy.isClickable = false
        }

        addProperties(meal)
        val carb = meal?.carb?.toFloatNumber() ?: 0f
        val protein = meal?.protein?.toFloatNumber() ?: 0f
        val fat = meal?.fat?.toFloatNumber() ?: 0f
        setupPieChart(meal?.calories)
        loadPieChartData(carb, protein, fat)

    }

    private fun addProperties(meal: Meal?) {
        binding.caffeineNumber.text = meal?.caffeine
        binding.waterNumber.text = meal?.water
        binding.carbNumber.text = meal?.carb
        binding.fatNumber.text = meal?.fat
        binding.countFiber.text = meal?.fiber
        binding.titleDetails.text = meal?.name
        binding.proteinNumber.text = meal?.protein
        binding.calciumNumber.text = meal?.calcium
        binding.cholesterolNumber.text = meal?.cholesterol
        binding.sugarNumber.text = meal?.sugar
    }

    override fun addCallBacks() {
        dataManager = arguments?.getSerializable(Constants.DATA_MANAGER_KEY) as DataManager

        binding.buttonDialy.setOnClickListener {
            meal?.let {
                dataManager.addItemToAddedItems(it)
            }

            Toast.makeText(context, "Added successfully", Toast.LENGTH_LONG).show()
            binding.buttonDialy.isClickable = false


        }
        binding.arrowIcon.setOnClickListener {
            this.parentFragmentManager.popBackStack()
        }
    }

    private fun setupPieChart(calories: String?) {
        binding.pieChartDetails.apply {
            centerText = "$calories\nCal"
            setCenterTextSize(12F)
            setUsePercentValues(true)
            description.isEnabled = false
            legend.isEnabled = false
        }
    }

    private fun loadPieChartData(carb: Float, protein: Float, fat: Float) {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.apply {
            add(PieEntry(carb))
            add(PieEntry(protein))
            add(PieEntry(fat))
        }

        val colors: ArrayList<Int> = ArrayList()
        colors.apply {
            add(rgb(getString(R.string.light_green_pie_chare))) // light green
            add(rgb(getString(R.string.mid_green_pie_chare))) // mid green
            add(rgb(getString(R.string.dark_green_pie_chare))) // dark green
        }

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = colors
        val data = PieData(dataSet)
        binding.pieChartDetails.data = data
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(binding.pieChartDetails))
        data.setValueTextSize(8f)
        data.setValueTextColor(Color.BLACK)
        binding.pieChartDetails.invalidate()
        binding.pieChartDetails.animateY(1400, Easing.EaseInOutQuad)
    }


    companion object {
        fun newInstance(meal: Meal, dataManager: DataManager): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(Constants.ID_KEY, meal)
                    putSerializable(Constants.DATA_MANAGER_KEY, dataManager)
                }
            }
        }
    }

}