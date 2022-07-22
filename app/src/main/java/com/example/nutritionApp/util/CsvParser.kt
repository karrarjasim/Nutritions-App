package com.example.nutritionApp.util

import com.example.nutritionApp.data.domain.Meal
import com.example.nutritionApp.interfaces.DataSource

class CsvParser : DataSource{

    override fun parse(line: String): Meal {
        val mList = line.split(",")
        return Meal(
            id = mList[Constants.ColumnIndex.ID].toInt(),
            name = mList[Constants.ColumnIndex.NAME],
            servingSize = mList[Constants.ColumnIndex.SERVING_SIZE],
            calories = mList[Constants.ColumnIndex.CALORIES],
            totalFat = mList[Constants.ColumnIndex.TOTAL_FAT],
            saturatedFat = mList[Constants.ColumnIndex.SATURATED_FAT],
            protein = mList[Constants.ColumnIndex.PROTEIN],
            fat = mList[Constants.ColumnIndex.FAT],
            caffeine = mList[Constants.ColumnIndex.CAFFEINE],
            water = mList[Constants.ColumnIndex.WATER],
            calcium = mList[Constants.ColumnIndex.CALCIUM],
            fiber = mList[Constants.ColumnIndex.FIBRE],
            sugar = mList[Constants.ColumnIndex.SUGAR],
            cholesterol = mList[Constants.ColumnIndex.CHOLESTEROL],
            carb = mList[Constants.ColumnIndex.CARB],
            vitaminD = mList[Constants.ColumnIndex.VITAMIN_D],
        )
    }

}