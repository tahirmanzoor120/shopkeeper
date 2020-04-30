package com.tahirmanzoor.shopkeeper.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is products Fragment"
    }
    val text: LiveData<String> = _text
}