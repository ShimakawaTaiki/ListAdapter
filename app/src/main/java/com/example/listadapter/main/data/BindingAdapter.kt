package com.example.listadapter.main.data

import android.widget.RadioButton
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.main.view.PrefectureListAdapter

@BindingAdapter("android:onItemSelected")
fun setIsSelected(view: RadioButton, isSelected: MutableLiveData<Boolean>) {
    val res =
        when (isSelected.value) {
            true -> true
            else -> false
        }
    view.isSelected = res
}