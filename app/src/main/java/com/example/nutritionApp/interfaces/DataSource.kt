package com.example.nutritionApp.interfaces

import com.example.nutritionApp.data.domain.Meal


interface DataSource {
    fun parse(line: String): Meal
}