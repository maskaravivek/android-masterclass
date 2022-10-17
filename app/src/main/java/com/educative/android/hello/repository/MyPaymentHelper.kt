package com.educative.android.hello.repository

import android.util.Log
import javax.inject.Inject

class MyPaymentHelper @Inject constructor() {

    var map = hashMapOf<String, Int>()
    fun makePayment(id: String, amount: Int): Boolean {
        if(map.containsKey(id)) {
            throw Exception("Duplicate payment exception")
        }
        map[id] = amount
        Log.d("MyPaymentRepository", "Payment initiated for $amount")
        return true
    }

    fun getPaymentAmount(id: String): Int {
        if (!map.containsKey(id)) {
            throw Exception("Payment receipt with id: $id not found")
        }

        return map[id]!!
    }
}