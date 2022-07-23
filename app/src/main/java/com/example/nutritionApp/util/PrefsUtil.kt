package com.example.nutritionApp.util

import android.content.Context
import android.content.SharedPreferences

object PrefsUtil {
    private var sharedPreferences: SharedPreferences? = null
    private const val SHARED_PREFS = "my_sharedPrefs"
    private const val KEY_AGE = "age"
    private const val KEY_HEIGHT = "height"
    private const val KEY_WIGHT = "weight"
    private const val KEY_ACTIVITY_FACTOR = "key_activity_factor"
    private const val KEY_Selected_ACTIVITY_FACTOR = "key_selected_activity_factor"


    private const val KEY_OPTIMAL_CALORIES = "optimal_calories"
    fun initSharedPreferences(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
    }

    var heightInform: Int?
        get() = sharedPreferences?.getInt(KEY_HEIGHT, 150)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(KEY_HEIGHT, it)?.apply() }
        }

    var ageInform: Int?
        get() = sharedPreferences?.getInt(KEY_AGE, 20)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(KEY_AGE, it)?.apply() }
        }


    var weightInform: Int?
        get() = sharedPreferences?.getInt(KEY_WIGHT, 75)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(KEY_WIGHT, it)?.apply() }
        }

    var activityFactorInform: String?
        get() = sharedPreferences?.getString(KEY_ACTIVITY_FACTOR, "0.0")
        set(value) {
            value?.let { sharedPreferences?.edit()?.putString(KEY_ACTIVITY_FACTOR, it)?.apply() }
        }

    var selectedActivityFactorInform: Int?
        get() = sharedPreferences?.getInt(KEY_Selected_ACTIVITY_FACTOR, -1)
        set(value) {
            value?.let {
                sharedPreferences?.edit()?.putInt(KEY_Selected_ACTIVITY_FACTOR, it)?.apply()
            }
        }


    var optimalCaloriesInform: Int?
        get() = sharedPreferences?.getInt(KEY_OPTIMAL_CALORIES, 0)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(KEY_OPTIMAL_CALORIES, it)?.apply() }
        }
}