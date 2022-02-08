package com.example.listadapter.main.data

import androidx.lifecycle.MutableLiveData

data class Prefecture(
    val name: String,
    val isChecked: MutableLiveData<Boolean> = MutableLiveData(false)
)
