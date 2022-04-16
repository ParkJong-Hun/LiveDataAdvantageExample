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

    private val _money: MutableLiveData<Int> = MutableLiveData(3000)
    val money: LiveData<Int> = _money
    val moneyForTextView = money.map {"${DecimalFormat("###,###").format(it)}$CURRENCY"}
    val isPurchasable = money.map {
        it >= 1000
    }

    fun charge() {
        _money.postValue(money.value!! + 2000)
    }

    fun buy() {
        _money.postValue(money.value!! - 1000)
    }
}