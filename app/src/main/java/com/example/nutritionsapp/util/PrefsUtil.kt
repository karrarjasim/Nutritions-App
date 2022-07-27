package com.example.nutritionsapp.util

import android.content.Context
import android.content.SharedPreferences

object PrefsUtil {
    private var sharedPreferences: SharedPreferences? = null


    fun initSharedPreferences(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE)
    }

    var heigth: Int?
        get() = sharedPreferences?.getInt(Constants.HEIGHT, 150)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(Constants.HEIGHT, it)?.apply() }
        }

    var age: Int?
        get() = sharedPreferences?.getInt(Constants.KEY_AGE, 20)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(Constants.KEY_AGE, it)?.apply() }
        }


    var weight: Int?
        get() = sharedPreferences?.getInt(Constants.WEIGHT, 75)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(Constants.WEIGHT, it)?.apply() }
        }


    var calories: Int?
        get() = sharedPreferences?.getInt(Constants.CALORIES_KEY, 0)
        set(value) {
            value?.let { sharedPreferences?.edit()?.putInt(Constants.CALORIES_KEY, it)?.apply() }
        }
}