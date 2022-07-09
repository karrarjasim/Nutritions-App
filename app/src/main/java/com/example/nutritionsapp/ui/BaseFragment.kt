package com.example.nutritionsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>( private val bindingInflater : (inflater : LayoutInflater) -> VB
): Fragment() {

    abstract var LOG_TAG : String
    private var _binding: VB? = null
    val binding: VB
    get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return _binding!!.root
    }

    override fun onStart() {
        super.onStart()
        addCallBacks()
    }

    abstract fun addCallBacks()

    fun log(value: Any){
        Log.v(LOG_TAG, value.toString())
    }
}