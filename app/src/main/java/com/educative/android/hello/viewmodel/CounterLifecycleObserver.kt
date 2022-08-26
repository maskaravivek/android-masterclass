package com.educative.android.hello.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class CounterLifecycleObserver : DefaultLifecycleObserver {
    private var myCounter = 0

    override fun onPause(owner: LifecycleOwner) {
        myCounter = 0
        super.onPause(owner)
    }

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