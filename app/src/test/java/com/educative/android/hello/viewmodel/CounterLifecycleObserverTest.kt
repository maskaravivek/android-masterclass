package com.educative.android.hello.viewmodel

import org.junit.Before
import org.junit.Test

internal class CounterLifecycleObserverTest {

    lateinit var viewModel: MyCounterViewModel

    @Before
    fun before() {
        viewModel = MyCounterViewModel()
    }

    @Test
    fun incrementCounter() {
        viewModel.incrementCounter()
        viewModel.incrementCounter()
        viewModel.incrementCounter()
        assert(viewModel.getCounter() == 3)
    }

    @Test
    fun decrementCounter() {
        viewModel.incrementCounter()
        viewModel.incrementCounter()
        viewModel.incrementCounter()
        viewModel.decrementCounter()
        assert(viewModel.getCounter() == 2)
    }

    @Test
    fun getCounter() {
        viewModel.incrementCounter()
        assert(viewModel.getCounter() == 1)
    }
}