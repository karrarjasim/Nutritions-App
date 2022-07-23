package com.example.nutritionApp.ui

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.nutritionApp.R
import com.example.nutritionApp.databinding.FragmentCalculateBinding
import com.example.nutritionApp.util.Constants
import com.example.nutritionApp.util.PrefsUtil


class CalculateFragment : BaseFragment<FragmentCalculateBinding>() {

    override var logTag = "CalculateFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalculateBinding
        get() = FragmentCalculateBinding::inflate

    private var age: Int = 20
    var height: Int = 150
    private var weight: Int = 75
    var activityFactor: Double = 0.0
    var calories: Int = 0


    override fun onStart() {
        super.onStart()
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.planets_array,
                R.layout.drop_down_item
            ).also { adapter ->
                adapter.setDropDownViewResource(R.layout.selected_drop_down_item)
                binding.spinner.adapter = adapter

            }
        }

    }


    override fun addCallBacks() {
        getSavedInforms()
        binding.ageSlider.addOnChangeListener { _, value, _ ->
            age = value.toInt()
            binding.ageValue.text = age.toString()
        }
        binding.heightSlider.addOnChangeListener { _, value, _ ->
            height = value.toInt()
            binding.heightValue.text = height.toString()

        }
        binding.weightSlider.addOnChangeListener { _, value, _ ->
            weight = value.toInt()
            binding.weightValue.text = weight.toString()
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                activityFactor = when (p2) {
                    0 -> 1.2
                    1 -> 1.55
                    2 -> 1.725
                    else -> 0.0
                }
                Log.v("activityFactor", activityFactor.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.v("item", "test")
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            binding.enterBtn.isEnabled = true
            if (checkedId == 1) {
                binding.male.isChecked = true
            } else {
                binding.female.isChecked = true

            }
        }

        binding.enterBtn.setOnClickListener {
            calories = if (binding.female.isChecked) {
                (((10 * weight) + (6.25 * height) - (5 * age) - 161) * activityFactor).toInt()
            } else {
                (((10 * weight) + (6.25 * height) - (5 * age) + 5) * activityFactor).toInt()
            }
            saveInforms()
            Intent(activity, HomeActivity::class.java).apply {
                putExtra(Constants.CALORIES_KEY, calories)
                putExtra(Constants.WEIGHT, weight)
                putExtra(Constants.HEIGHT, height)
            }.also {
                startActivity(it)
                activity?.finish()
            }
        }


    }

    private fun saveInforms() {
        PrefsUtil.ageInform = age
        PrefsUtil.heightInform = height
        PrefsUtil.weightInform = weight
        PrefsUtil.optimalCaloriesInform = calories
    }

    private fun getSavedInforms() {
        if (PrefsUtil.heightInform != null || PrefsUtil.heightInform != 0) {
            height = PrefsUtil.heightInform!!
            binding.heightSlider.value = height.toFloat()
            binding.heightValue.text = height.toString()
        }
        if (PrefsUtil.weightInform != null || PrefsUtil.weightInform != 0) {
            weight = PrefsUtil.weightInform!!
            binding.weightSlider.value = weight.toFloat()
            binding.weightValue.text = weight.toString()
        }
        if (PrefsUtil.optimalCaloriesInform != null || PrefsUtil.optimalCaloriesInform != 0) {
            calories = PrefsUtil.optimalCaloriesInform!!
        }
    }

    // needing the calculated calories // age // weight // height // body fat // selected items and progress percentage // searched items


}











