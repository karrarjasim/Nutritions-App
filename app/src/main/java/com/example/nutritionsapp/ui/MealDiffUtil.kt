package com.example.nutritionsapp.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.nutritionsapp.data.domain.Meal

class MealDiffUtil(val mOldList: List<Meal>, val mNewList: List<Meal>): DiffUtil.Callback() {

    override fun getOldListSize() =  mOldList.size

    override fun getNewListSize() = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldList[oldItemPosition].name == mNewList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}