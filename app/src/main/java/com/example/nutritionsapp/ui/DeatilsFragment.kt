package com.example.nutritionsapp.ui

import android.graphics.Color
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.databinding.FragmentDetailsBinding
import com.example.nutritionsapp.databinding.FragmentDetailsBinding.*
import com.example.nutritionsapp.util.Constants
import com.example.nutritionsapp.util.Converter
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb

class DeatilsFragment: BaseFragment<FragmentDetailsBinding>() {

    override var LOG_TAG = Constants.DEATILS_KEY

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get()= FragmentDetailsBinding::inflate
    var meals =DataManager()


    override fun onStart() {
        super.onStart()
        val id = arguments?.getInt(Constants.ID_KEY)
        var meal= meals.getMealByID(1)
        setupPieChart(meal.calories)
        loadPieChartData()

//        println("hiiiiiiiiiiiiiiiiiiiiii ${meal.name}")
//        println("hiiiiiigggggggggggggggggggggggggggiii ${meal[1].caffeine}")
    }
//
    override fun addCallBacks() {
    }



//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val id = arguments?.getInt(Constants.ID_KEY)
//        var meal= meals.getMealByID(1)
//        setupPieChart(meal.calories)
//        loadPieChartData()
//
//        println("hiiiiiiiiiiiiiiiiiiiiii ${meal.name}")
//        println("hiiiiiigggggggggggggggggggggggggggiii ${meal.caffeine}")
//    }

    private fun setupPieChart( calories:String) {
        binding.pieChartDetails.apply {
            centerText = "${calories}\nCal"
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
            add(rgb("#0064E5"))
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

//    companion object {
//
//        fun newInstance(id : Int):DeatilsFragment {
//            return DeatilsFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(Constants.ID_KEY, id)
//                }
//            }
//        }
//    }
}