package com.example.colorpickerdemo

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorPickerViewModel : ViewModel() {

    private val _selectedColor = MutableLiveData<Int>()
    val selectedColor: LiveData<Int>
        get() = _selectedColor

    private val _brightness = MutableLiveData<Int>()
    val brightness: LiveData<Int>
        get() = _brightness

    init {
        _selectedColor.value = Color.parseColor("#00c2a3")
        _brightness.value = 100
    }

    fun setSelectedColor(color: Int) {
        _selectedColor.value = color
    }

}
