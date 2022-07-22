package com.example.nutritionsapp.interfaces

import com.example.nutritionsapp.data.domain.Meal


interface DataSource {
    fun parse(line: String): Meal
}