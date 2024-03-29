package com.example.nutritionsapp.ui

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.nutritionsapp.R
import com.example.nutritionsapp.databinding.FragmentCalculateBinding
import com.example.nutritionsapp.util.Constants
import com.example.nutritionsapp.util.PrefsUtil


class CalculateFragment: BaseFragment<FragmentCalculateBinding>() {

    override var LOG_TAG = "CalculateFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalculateBinding
        get() = FragmentCalculateBinding::inflate

    var age: Int = 20
    var height: Int = 150
    var weight: Int = 75
    var activityFactor: Double = 1.2 // The  activity factor is a function of the type of activity for an individual
    var calories: Int = 0


    override fun onStart() {
        super.onStart()

        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.planets_array,
                R.layout.drop_down_item
            ).also {
                adapter ->
                adapter.setDropDownViewResource(R.layout.selected_drop_down_item)
                binding.spinner.adapter = adapter

            }
        }
        if (PrefsUtil.calories !== 0){
            val intent = Intent(activity, HomeActivity::class.java).apply {
                putExtra(Constants.CALORIES_KEY, PrefsUtil.calories)
                putExtra(Constants.WEIGHT, PrefsUtil.weight)
                putExtra(Constants.HEIGHT, PrefsUtil.heigth)
            }.also {
                startActivity(it)
                activity?.finish()
            }
        }

    }

    override fun addCallBacks(){
        binding.ageSlider.addOnChangeListener {slider, value, fromUser->
            age = value.toInt()
            binding.ageValue.text = age.toString()
        }
        binding.heightSlider.addOnChangeListener {slider, value, fromUser->
            height = value.toInt()
            binding.heightValue.text = height.toString()
        }
        binding.weightSlider.addOnChangeListener {slider, value, fromUser->
            weight = value.toInt()
            binding.weightValue.text = weight.toString()
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p2){
                    0 -> activityFactor = 1.2
                    1 -> activityFactor = 1.55
                    2 -> activityFactor = 1.725
                }
                Log.v("activityFactor", activityFactor.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.v("item", "test")
            }

        }

        binding.radioGroup.setOnCheckedChangeListener{ _, _ ->
            binding.enterBtn.isEnabled = true
        }

        binding.enterBtn.setOnClickListener() {

            calories = if (binding.female.isChecked) {
                   (((10 * weight) + (6.25 * height) - (5 * age) - 161) * activityFactor).toInt()
            }else{
                  (((10 * weight) + (6.25 * height) - (5 * age ) + 5 ) * activityFactor).toInt()
            }
            saveUserInfo()
            val intent = Intent(activity, HomeActivity::class.java).apply {
                putExtra(Constants.CALORIES_KEY, calories)
                putExtra(Constants.WEIGHT, weight)
                putExtra(Constants.HEIGHT, height)
            }.also {
                startActivity(it)
                activity?.finish()
            }
        }



    }

    fun saveUserInfo(){
        PrefsUtil.age = age
        PrefsUtil.heigth = height
        PrefsUtil.weight = weight
        PrefsUtil.calories = calories
    }




}