package com.example.nutritionsapp.data.domain

import android.os.Parcel
import android.os.Parcelable

data class Meal(
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
) : Parcelable {
    constructor(parcel: Parcel) : this (
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Meal> {
        override fun createFromParcel(parcel: Parcel): Meal {
            return Meal(parcel)
        }

        override fun newArray(size: Int): Array<Meal?> {
            return arrayOfNulls(size)
        }
    }

}