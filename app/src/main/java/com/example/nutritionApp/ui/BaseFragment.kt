package com.example.nutritionApp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.nutritionApp.interfaces.NavigationInterface

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract var logTag: String
    private var _binding: VB? = null
    abstract val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> VB
    protected val binding: VB
        get() = _binding as VB
    var listener: NavigationInterface? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onStart() {
        super.onStart()
        addCallBacks()
    }


    abstract fun addCallBacks()

    fun log(value: Any) {
        Log.v(logTag, value.toString())
    }

}