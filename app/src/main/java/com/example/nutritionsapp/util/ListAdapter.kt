package com.example.nutritionsapp.util

import android.app.Activity
import android.widget.ArrayAdapter
import com.example.nutritionsapp.R
import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.ui.BaseFragment

class ListAdapter(private val context: Activity, private val arrayList: ArrayList<Meal>) :
    ArrayAdapter<Meal>(context, R.layout.fragment_calorie, arrayList) {




}