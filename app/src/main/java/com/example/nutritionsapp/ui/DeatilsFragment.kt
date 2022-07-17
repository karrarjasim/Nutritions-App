package com.example.nutritionsapp.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentDetailsBinding
import com.example.nutritionsapp.util.Constants
import com.example.nutritionsapp.util.CsvParser
import com.example.nutritionsapp.util.toFloatNumber
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.InputStreamReader

class DeatilsFragment: BaseFragment<FragmentDetailsBinding>() {

    override var LOG_TAG = Constants.DEATILS_KEY

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get()= FragmentDetailsBinding::inflate

    override fun onStart() {
        super.onStart()

        val meal = arguments?.getParcelable<Meal>(Constants.ID_KEY)
        addProperties(meal)
        val carb= requireNotNull(meal?.carb?.toFloatNumber())
        val  protein = requireNotNull(meal?.protein?.toFloatNumber())
        val  fat = requireNotNull(meal?.fat?.toFloatNumber())
        setupPieChart(meal?.calories)
        loadPieChartData(carb,protein,fat)

    }

    private fun addProperties(meal: Meal?) {
        binding.caffeineNumber.text = meal?.caffeine
        binding.waterNumber.text =meal?.water
        binding.carbNumber.text =meal?.carb
        binding.fatNumber.text =meal?.fat
        binding.countFiber.text =meal?.fiber
        binding.titleDetails.text =meal?.name
        binding.proteinNumber.text =meal?.protein
        binding.calciumNumber.text =meal?.calcium
        binding.cholesterolNumber.text =meal?.cholesterol
        binding.sugarNumber.text =meal?.sugar
    }

    override fun addCallBacks() {
        binding.btnDialy.setOnClickListener {
            binding.btnDialy.text = getString(R.string.done)
        }
        binding.arrowIcon.setOnClickListener {
            this.parentFragmentManager.popBackStack()
        }
    }



    private fun setupPieChart( calories:String?) {
        binding.pieChartDetails.apply {
            centerText ="$calories\nCal"
            setCenterTextSize(12F)
            setUsePercentValues(true)
            description.isEnabled = false
            legend.isEnabled = false
        }
    }

    private fun loadPieChartData(carb :Float ,protein:Float,fat :Float) {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.apply {
            add(PieEntry(carb ))
            add(PieEntry(protein))
            add(PieEntry(fat))
        }

        val colors: ArrayList<Int> = ArrayList()
        colors.apply {
            add(rgb(getString(R.string.blue)))
            add(rgb(getString(R.string.red)))
            add(rgb(getString(R.string.yellow)))
        }

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = colors
        val data = PieData(dataSet)
        binding.pieChartDetails.data = data
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(binding.pieChartDetails))
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.BLACK);
        binding.pieChartDetails.invalidate()
        binding.pieChartDetails.animateY(1400, Easing.EaseInOutQuad)
    }


    companion object {
        fun newInstance(meal :Meal):DeatilsFragment {
            return DeatilsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(Constants.ID_KEY, meal)

                }
            }
        }
    }


}