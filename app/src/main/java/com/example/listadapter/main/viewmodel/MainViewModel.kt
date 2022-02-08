package com.example.listadapter.main.viewmodel

import androidx.lifecycle.*
import com.example.listadapter.main.data.Prefecture

class MainViewModel: ViewModel() {
    val hokkaido = Prefecture("北海道")
    val tokyo = Prefecture("東京", MutableLiveData(true))
    val nagoya = Prefecture("名古屋")
    val osaka = Prefecture("大阪")
    val hukuoka = Prefecture("福岡")

    val prefectureList = mutableListOf(hokkaido, tokyo, nagoya, osaka, hukuoka)

    private val _prefectures = MutableLiveData<List<Prefecture>>(prefectureList)
    val prefectures: LiveData<List<Prefecture>> = _prefectures.distinctUntilChanged()

    var selected: String? = null

    private val _click = MutableLiveData("Clicked!!")
    val click = _click as LiveData<String>

    fun onClickItem(prefecture: Prefecture) {
        prefectureList.forEach {
            it.isChecked.value = false
        }
        prefecture.isChecked.value = true
    }

    fun onButtonClick() {
        prefectureList.forEach {
            it.isChecked.value?.let { isChecked ->
                if (isChecked) {
                    selected = it.name
                }
            }
        }
        _click.value = "Clicked!!"
    }
}