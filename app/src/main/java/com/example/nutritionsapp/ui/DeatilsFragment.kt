package com.example.nutritionsapp.ui

import android.graphics.Color
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.R
import com.example.nutritionsapp.databinding.FragmentDetailsBinding
import com.example.nutritionsapp.databinding.FragmentDetailsBinding.*
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb

class DeatilsFragment: Fragment() {
   lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = inflate(inflater ,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPieChart()
        loadPieChartData()
    }
////

    private fun setupPieChart() {
        binding.pieChartDetails.apply {
            centerText = "163\nCal"
            setCenterTextSize(12F)
            setUsePercentValues(true)
            description.isEnabled = false
            legend.isEnabled = false
        }
    }

    private fun loadPieChartData() {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.apply {
            add(PieEntry(0.5f ))
            add(PieEntry(0.3f))
            add(PieEntry(0.2f))
        }

        val colors: ArrayList<Int> = ArrayList()
        colors.apply {
            add(rgb("#40966C"))
            add(rgb("#FF6752"))
            add(rgb("#FAB131"))
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
}