package com.example.aps.ui.konfiguracia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KonfiguraciaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "1"
    }
    val text: LiveData<String> = _text
}