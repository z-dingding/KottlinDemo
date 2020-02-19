package com.hxzk.kottlindemo.Coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutinesHangUpFunActivity : AppCompatActivity() {

    private val TAG = "CoroutinesHangUpFunActivity"

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_hang_up_fun)

//        GlobalScope.launch {
//            val time = measureTimeMillis {
//                //async 可以通过将 start 参数设置为 CoroutineStart.LAZY 而变为惰性的。
//                val one = async(start = CoroutineStart.LAZY) { funOne() }
//                val two = async(start = CoroutineStart.LAZY) { funTwo() }
//                //只有结果通过 await 获取的时候协程才会启动(顺序执行)，或者在 Job 的 start 函数调用的时候（并发执行）
//                one.start()
//                two.start()
//                Log.e(TAG, "The answer is ${one.await() + two.await()}")// The answer is 4039
//            }
//            Log.e(TAG, "Completed in $time ms")// Completed in 2023 ms
//        }



        //async函数的另一种写发，好处是：这些 xxxAsync 函数不是 挂起 函数。它们可以在任何地方使用
        //使用 async 协程建造器并带有一个显式的 GlobalScope 引用
        //但不推荐使用
//        fun asyncOne() = GlobalScope.async { funOne() }
//        fun asyncTwo() = GlobalScope.async { funTwo() }
//        //不需要在协程调用直接写
//        val timeAsyne = measureTimeMillis {
//            val one = asyncOne()
//            val two = asyncTwo()
//            // 但是等待结果必须调用其它的挂起或者阻塞,使用 `runBlocking { …… }` 来阻塞主线程
//            runBlocking {
//                Log.e(TAG, "The answer is ${one.await() + two.await()}")// The answer is 4039
//            }
//        }
//        Log.e(TAG, "Completed in $timeAsyne m)// Completed in 2023 ms


        //第三种写法
        suspend fun sumResult() :Int = coroutineScope{
            val one =async {funOne()}
            val two = async {funTwo()}
             one.await()+two.await()
        }
        GlobalScope.launch {
            val time = measureTimeMillis {
                Log.e(TAG,"The answer is ${sumResult()}")//The answer is 4039
            }
            Log.e(TAG,"Completed in $time ms")//Completed in 2021 ms
        }

    }
    /**
     * 自定义挂起函数，必须放在协程中执行
     * 挂起函数一般都得有delay(),withContext()方法调用
     */
    private suspend fun funOne(): Int {
        delay(2000L)
        return 2020
    }

    private suspend fun funTwo(): Int {
        delay(2000L)
        return 2019
    }
}
