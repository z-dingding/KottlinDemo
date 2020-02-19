package com.hxzk.kottlindemo.Coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class CoroutinesCancelWithTimeOutActivity : AppCompatActivity(),CoroutineScope {
    private val TAG = "CoroutinesCancelWithTimeOut"

    lateinit var job: Job
    lateinit var timeoutJob: Job


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancel_with_time_out)
        GlobalScope.launch {
            //挂起函数只能在协程中使用
            cancelMethod()
        }
        //timeOutMethod()
    }
    private suspend fun cancelMethod() {
        val coroutineScope = CoroutineScope(coroutineContext)
        job = coroutineScope.launch(Dispatchers.IO) {
            repeat(1000) { i ->
                Log.e(TAG, "job: I'm sleeping $i")
                delay(500L)
            }
        }
        delay(1200L)
        Log.e(TAG, "main: I'm tired of waiting!")
        job.cancel() // 取消该作业
        job.join() // 等待作业执行结束
        Log.e(TAG, "main: Now I can quit.")
    }


    @SuppressLint("LongLogTag")
    private  fun timeOutMethod() {
        val coroutineScope = CoroutineScope(coroutineContext)
        timeoutJob = coroutineScope.launch(Dispatchers.IO) {
            //withTimeoutOrNull()设置超时时间
            // withTimeoutOrNull 通过返回 null 来进行超时操作，从而替代抛出一个异常
           val result = withTimeoutOrNull(1300L) {
                repeat(1000) { i ->
                    Log.e(TAG, "job: I'm sleeping $i")
                    delay(500L)
                }
       }
            Log.e(TAG,"Result is $result")
    }
}

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        timeoutJob.cancel()
    }
}
