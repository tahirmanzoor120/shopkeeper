package com.tahirmanzoor.shopkeeper.ui.billing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BillingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is billing Fragment"
    }
    val text: LiveData<String> = _text
}