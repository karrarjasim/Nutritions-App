package com.example.nutritionsapp.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nutritionsapp.data.DataManager
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.databinding.FragmentDetailsBinding
import com.example.nutritionsapp.util.Constants
import com.example.nutritionsapp.util.CsvParser
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

    private val meals =DataManager()
     var carb =""
     var protien =""
     var fat =""
    private val categoryFragment = CategoryFragment()

    override fun onStart() {
        super.onStart()
        openFile()
        var id = arguments?.getInt(Constants.ID_KEY)
        val meal= meals.getMealByID(7)
        setupPieChart(meal?.calories)
        loadPieChartData()
         addProperties(meal)

        var carbN  = meal?.carb!!.split(" ")
        var protienN  = meal?.protein!!.split(" ")
        var fatN  = meal?.fat!!.split(" ")
        carb = carbN[0]
        protien =protienN[0]
        fat =fatN[0]
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

    private fun openFile() {
        var inputStream = activity?.assets?.open("nutrition.csv")
        val buffer =BufferedReader(InputStreamReader(inputStream))
        val parser =CsvParser()
        buffer.forEachLine {
            val meal = parser.parse(it)
            meals.addMeal(meal)
        }
    }

    override fun addCallBacks() {
        binding.btnDialy.setOnClickListener {
            binding.btnDialy.text = "Done"
        }
        binding.arrowIcon.setOnClickListener {
            openCategoryDetails()
        }
    }
    private fun openCategoryDetails(){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(this, CategoryFragment )
//        transaction.commit()
    }


        private fun setupPieChart( calories:String?) {
        binding.pieChartDetails.apply {
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
            add(PieEntry(0.4f ))
            add(PieEntry(0.3f))
            add(PieEntry(0.2f))
        }
//        add(PieEntry(water.toFloat() ))
//        add(PieEntry(sugar.toFloat()))
//        add(PieEntry(fat.toFloat()))

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



//    private fun  openCalorie(id :Int ){
//        val calorieFragment = CalorieFragment.newInstance(id)
//
//    }


    companion object {

        fun newInstance(id : Int):DeatilsFragment {
            return DeatilsFragment().apply {
                arguments = Bundle().apply {
                    getInt(Constants.ID_KEY, id)
//                    putInt(Constants.ID_KEY, id)

                }
            }
        }
    }
}