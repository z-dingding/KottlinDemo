package com.hxzk.kottlindemo.Coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
Autour: ${zjt}
Date: ${DATE}
Description: 协程-基本
 **/

class CoroutinesBasicActivity : AppCompatActivity() {
    private val TAG = "CoroutinesBasicActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_basic)
        main()
    }


    //显式使用 runBlocking 协程构建器来阻塞
    fun main() = runBlocking{
        // 在后台启动一个新的协程并继续
        //在 GlobalScope 中启动的活动协程并不会使进程保活。它们就像守护线程
        GlobalScope.launch {
            //非阻塞的 delay(……) 与 阻塞的 Thread.sleep(……)
            delay(1000L)
            Log.e(TAG, "World!")
        }
        Log.e(TAG, "Hello,")/// 主线程中的代码会立即执行
        delay(2000L)  //我们延迟 2 秒来保证 JVM 的存活
    }
}