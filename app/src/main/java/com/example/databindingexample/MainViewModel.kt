package com.example.databindingexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import java.text.DecimalFormat

class MainViewModel: ViewModel() {
    companion object {
        const val CURRENCY = "￦"
    }

    private val _money: MutableLiveData<Int> = MutableLiveData(1000)
    val money: LiveData<Int> = _money
    val moneyForTextView = MutableLiveData("${DecimalFormat("###,###").format(_money.value)}$CURRENCY")
    val isSmall = _money.map {
        it <= 1000
    }

    fun charge() {
        _money.postValue(_money.value?:0 + 2000)
    }

    fun buy() {
        _money.postValue(_money.value?:0 - 1000)
    }
}