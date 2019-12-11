package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class IntervalAndSequence : AppCompatActivity() {
    private   val TAG="IntervalAndSequence"


    val mutableList = mutableListOf(1,2,3,4,5,6,7,8,9,10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interval_and_sequence)
        rangeTo()
        downTo()
        step()
        until()
    }


    /**
     * 正常打印从小到大的区间
     */
    fun rangeTo(){
        val mutableIterator =mutableList.listIterator()
        while (mutableIterator.hasNext()) {
            var num = mutableIterator.next()
            //等同于 num大于等于3小于等于5
            if (num in 3..5) {
                Log.e(TAG, "正常打印从小到大的区间$num")
            }
        }
    }


    /**
     * 以相反的顺序迭代数字
     */
    fun downTo(){
            //若要以相反的顺序迭代数字，请使用downTo,结果5，4，3
            for(num in 5 downTo 3){
                Log.e(TAG,"相反的顺序迭代数字$num")
            }
    }

    /**
     * 使用任意步骤对数字进行迭代，如果setp 2代表获取第n+2个元素的值，从第一个元素开始，第二次就是第三个元素，第三次就是第第五个元素
     */
    fun step(){
        val mutableIterator =mutableList.listIterator()
        while (mutableIterator.hasNext()){
            var num =mutableIterator.next()
            //也可以使用任意步骤(不一定是1)对数字进行迭代。这是通过step函数实现的，结果3，5，7
            if(num in 3..7 step 2){
                Log.e(TAG,"使用任意步骤对数字进行迭代$num")
            }
        }
    }

    /**
     * 若要迭代不包含其结束元素的number范围，请使用until函数，等同于[1, 10)
     */
    fun until(){
        val mutableIterator =mutableList.listIterator()
        while (mutableIterator.hasNext()){
            var num =mutableIterator.next()
            //若要迭代不包含其结束元素的number范围，请使用until函数
            if(num in 3 until 6){// i in [3, 6), 6 is excluded
                Log.e(TAG,"不包含其结束元素的number范围$num")
            }
        }
    }

}
