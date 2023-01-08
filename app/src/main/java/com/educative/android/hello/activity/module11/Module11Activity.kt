package com.educative.android.hello.activity.module11

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.os.Process.*
import androidx.appcompat.app.AppCompatActivity
import com.educative.android.hello.executor.MyExecutor
import com.example.educative.hello.R
import java.util.concurrent.*

class Module11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_11)
    }


    private fun newThread() {
        val thread: Thread = object : Thread() {
            override fun run() {
                setThreadPriority(THREAD_PRIORITY_LOWEST);
                // your code here
            }
        }
        thread.start()
    }

    private fun threadPoolExecutor() {
        val numberOfCores: Int = Runtime.getRuntime().availableProcessors()
        val keepAliveTime: Long = 30
        val threadPoolExecutor = ThreadPoolExecutor(
            numberOfCores,
            numberOfCores * 2,
            keepAliveTime,
            TimeUnit.SECONDS,
            LinkedBlockingDeque()
        )

        threadPoolExecutor.submit {
            // execute new task
        }
    }

    private fun executor() {
        var executor = MyExecutor()
        executor.execute {
            var sum = 10 + 5
        }
    }

    private fun fixedSizeThreadPool() {
        val executorService: ExecutorService = Executors.newFixedThreadPool(4)
        executorService.submit {
            //submit new task
        }
    }

    private fun getMemoryInfo(): ActivityManager.MemoryInfo {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        return ActivityManager.MemoryInfo().also { memoryInfo ->
            activityManager.getMemoryInfo(memoryInfo)
        }
    }

    private fun performSomeTask() {
        if (!getMemoryInfo().lowMemory) {
            //your code here
        }
    }
}