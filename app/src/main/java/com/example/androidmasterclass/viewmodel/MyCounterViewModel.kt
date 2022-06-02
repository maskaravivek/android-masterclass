package com.example.androidmasterclass.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel

class MyCounterViewModel : ViewModel(), DefaultLifecycleObserver {
    private var myCounter = 0

    fun incrementCounter() {
        myCounter++
    }

    fun decrementCounter() {
        myCounter--
    }

    fun getCounter(): Int {
        return myCounter
    }
}