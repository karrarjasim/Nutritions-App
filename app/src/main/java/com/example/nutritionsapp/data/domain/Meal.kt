package com.example.nutritionsapp.data.domain

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Meal(
    val id: Int,
    val name: String,
    val servingSize: String,
    val calories: String,
    val totalFat:String,
    val saturatedFat: String,
    val protein: String,
    val fat: String,
    val caffeine: String,
    val vitaminD: String,
    val carb: String,
    val fiber: String,
    val water: String,
    val sugar: String,
    val calcium: String,
    val cholesterol: String,
) : Serializable {


}