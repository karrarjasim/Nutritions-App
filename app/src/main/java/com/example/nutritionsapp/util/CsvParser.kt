package com.example.nutritionsapp.util

import com.example.nutritionsapp.data.domain.Meal
import com.example.nutritionsapp.interfaces.DataSource
import java.io.File

class CsvParser() {

     fun parse(line: String): Meal {
        val mList = line.split(",")
        return Meal(
            name = mList[Constants.ColumnIndex.NAME],
            servingSize = mList[Constants.ColumnIndex.SERVING_SIZE],
            calories = mList[Constants.ColumnIndex.CALORIES],
            totalFat = mList[Constants.ColumnIndex.TOTAL_FAT],
            saturatedFat = mList[Constants.ColumnIndex.SATURATED_FAT],
            protein = mList[Constants.ColumnIndex.PROTEIN],
            fat = mList[Constants.ColumnIndex.FAT],
            caffeine = mList[Constants.ColumnIndex.CAFFEINE],
            vitaminD = mList[Constants.ColumnIndex.VITAMIN_D],
            carb = mList[Constants.ColumnIndex.CARB],
            fiber = mList[Constants.ColumnIndex.FIBER]
        )
    }

}