package com.example.nutritionsapp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.databinding.FragmentHomeBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb


class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override var LOG_TAG = "HOME_FRAGMENT"

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun addCallBacks() {

    }

    override fun onStart() {
        super.onStart()
        val calorie = arguments?.getInt("calorie")
        setupPieChart(calorie.toString())
        loadPieChartData()
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