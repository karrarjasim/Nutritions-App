package com.example.nutritionsapp.data

import com.example.nutritionsapp.data.domain.Meal

class DataManager {
    private val mealsList = mutableListOf<Meal>()

    fun addMeal(meal: Meal){
        mealsList.add(meal)
    }


    var mlist= mutableListOf<Meal>(
        Meal(
        name ="Quail - raw - meat only",
        servingSize=  "100",
        calories = "134",
        totalFat = "4.5 g",
        saturatedFat = "1.3",
        protein = "21.76",
        fat = "4.53 g",
        caffeine = "0",
        ),
        Meal(
            name ="Chicken - boiled - feet",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "19.40",
            fat = "4.53 g",
            caffeine = "0",

            ),
        Meal(
            name ="Fish - raw - milkfish",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "20.53",
            fat = "4.53 g",
            caffeine = "0",

            ),
        Meal(
            name ="Emu - raw - full rump",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "20.53",
            fat = "4.53 g",
            caffeine = "0",

            ),
        Meal(
            name ="Quail - raw2",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "2",
            fat = "4.53 g",
            caffeine = "0",

            ),
        Meal(
            name ="Quail - raw3",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "0",
            fat = "4.53 g",
            caffeine = "0",

            ),
        Meal(
            name ="Quail - raw4",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "0",
            fat = "4.53 g",
            caffeine = "0",

            ),
        Meal(
            name ="Quail - raw5",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "0",
            fat = "4.53 g",
            caffeine = "0",

            ),
        Meal(
            name ="Quail - raw6",
            servingSize=  "100",
            calories = "134",
            totalFat = "4.5 g",
            saturatedFat = "1.3",
            protein = "0",
            fat = "4.53 g",
            caffeine = "0",

            )



    )
}

