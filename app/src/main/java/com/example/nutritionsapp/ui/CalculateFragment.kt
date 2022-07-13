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


class CalculateFragment: BaseFragment<FragmentCalculateBinding>() {

    override var LOG_TAG = "CalculateFragment"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCalculateBinding
        get() = FragmentCalculateBinding::inflate

    var age: Int = 20
    var height: Int = 150
    var weight: Int = 70
    var activityFactor: Double = 1.2
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

        binding.enterBtn.setOnClickListener() {
            if (binding.female.isChecked) {
                calories =  (((10 * weight) + (6.25 * height) - (5 * age) - 161) * activityFactor).toInt()
            }else{
                calories =  (((10 * weight) + (6.25 * height) - (5 * age ) + 5 ) * activityFactor).toInt()
            }
            log(calories)

            val intent = Intent(activity, HomeActivity::class.java).apply {
                putExtra(Constants.CALORIES_KEY, calories)
            }
            startActivity(intent)
            activity?.finish()
        }


    }






}