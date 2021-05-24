package com.bangkit.academy.wastemanagement.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Olah Sampah Lebih Baik"
    }
    val text: LiveData<String> = _text
}