package com.educative.android.hello.executor

import java.util.concurrent.Executor

internal class MyExecutor : Executor {
    override fun execute(r: Runnable) {
        Thread(r).start();
    }
}