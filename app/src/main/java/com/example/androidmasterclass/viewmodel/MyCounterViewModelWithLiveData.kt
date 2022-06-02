package com.example.androidmasterclass.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyCounterViewModelWithLiveData : ViewModel(), DefaultLifecycleObserver {
    val myCounter = MutableLiveData<Int>()

    init {
        myCounter.value = 0
    }

    fun incrementCounter() {
        myCounter.value = (myCounter.value)?.plus(1)
    }

    fun decrementCounter() {
        myCounter.value = (myCounter.value)?.minus(1)
    }
}