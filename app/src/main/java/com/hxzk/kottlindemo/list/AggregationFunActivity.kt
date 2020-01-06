package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class AggregationFunActivity : AppCompatActivity() {

    private val TAG ="AggregationFunActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aggregation_fun_action)
        //常用聚合函数
        //commonlyUsedFun()
        foldWithReduce()
    }

    fun   foldWithReduce(){
        val numbers = listOf(5, 2, 10, 4)
        //fold()提供一个初始值然后元素累加
        Log.e(TAG,numbers.fold(10){a , b -> a+b }.toString())//结果为:31
        //reduce()从第一个元素开始累加
        Log.e(TAG,numbers.reduce{a,b -> a+b}.toString())//结果为:21
        //若要以相反的顺序将函数应用于元素，请使用reduceRight()和foldRight()函数.
        // 工作方式类似于fold()和reduce(),从最后一个元素开始，然后继续前一个元素,结果应该是一样的
        Log.e(TAG,numbers.foldRight(10){a , b -> a+b }.toString())//结果为:31
        Log.e(TAG,numbers.reduceRight{a,b -> a+b}.toString())//结果为:21
        //还可以将元素索引作为参数的操作。为此，使用reduceIndexed()和foldIndexed()函数传递元素索引作为操作的第一个参数
        Log.e(TAG,numbers.reduceIndexed { index, acc, i ->  index +acc+i }.toString())//结果为:27
        Log.e(TAG,numbers.foldIndexed(10){index, acc, i ->  index +acc+i}.toString())//结果为:37
        //同样的reduceRightIndexed()和foldRightIndexed()函数也是从后往前
        Log.e(TAG,numbers.reduceRightIndexed { index, i, acc -> index +acc+i }.toString())//结果为:24
        Log.e(TAG,numbers.foldRightIndexed(10){index, acc, i ->  index +acc+i}.toString())//结果为:37
    }

    fun commonlyUsedFun(){
        val list = listOf(3,45,67,9,32)
        //min()和max()分别返回最小和最大的元素
        Log.e(TAG,"max()获取最大的元素"+list.max().toString())// max()获取最大的元素67
        Log.e(TAG,"min()获取最小的元素"+list.min().toString())//min()获取最小的元素3
        //average()返回集合中元素的平均值
        Log.e(TAG,"average()获取元素的平均值"+list.average().toString())//average()获取元素的平均值31.2
        //sum()返回集合中元素的和
        Log.e(TAG,"sum()获取集合中元素的和"+list.sum().toString())//sum()获取集合中元素的和156
        //count()返回集合中的元素数量
        Log.e(TAG,"count()获取集合中的元素数量"+list.count().toString())// count()获取集合中的元素数量5
        //maxBy()/minBy()接受一个选择器函数并返回它所返回的最大或最小值的元素
        Log.e(TAG,"maxBy()求余数最大的元素"+list.maxBy { it % 3 })//maxBy()求余数最大的元素32
        //maxWith()/minWith()获取一个比较器对象，并根据该比较器返回最大或最小的元素
        val  array = arrayListOf("one","two","three","four","five","six","seven")
        Log.e(TAG,"maxWith()获取长度最大的元素"+array.maxWith(compareBy { it.length }))//maxWith()获取长度最大的元素three
       //sumBy()应用在集合元素上返回Int值的函数
        Log.e(TAG,list.sumBy { it * 2 }.toString())//结果为：312
        //sumByDouble()使用返回Double的函数
        Log.e(TAG,list.sumByDouble { it.toDouble() / 2 }.toString())//结果为：78.0
    }
}
