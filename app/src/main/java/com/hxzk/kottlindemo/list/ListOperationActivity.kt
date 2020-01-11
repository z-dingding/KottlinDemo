package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class ListOperationActivity : AppCompatActivity() {

    private val TAG = "ListOperationActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_operation)
        //通过binarySearch()在有序列表中二分查找
        //binaryFun()
        //集合的排序
        orderFun()
    }

    fun orderFun() {
        val list = mutableListOf("one", "two", "three", "four", "five")
        //sort()方法应用于可变集合的排序，改变了原集合的元素顺序，而sorted()方法可以用于不可变集合的排序
        list.sort()
        Log.e(TAG, "调用sort()$list")//[five, four, one, three, two]
        //sortDescending()函数与sort()正好相反
        list.sortDescending()
        Log.e(TAG, "调用sort()$list")//[two, three, one, four, five]
        //reverse()函数和sortDescending()函数一样的效果：倒序
        list.reverse()
        Log.e(TAG, "调用reverse()$list")//[five, four, one, three, two]
        //shuffle()函数将顺序打乱
        list.shuffle()
        Log.e(TAG, "调用shuffle()$list")//[three, one, four, two, five]
        //sortBy()函数按照指定规则排序
        list.sortBy { it.length }
        Log.e(TAG, "调用sortBy()$list")//[one, two, four, five, three]
        //sortWith()可以根据两个规则排序
        //现根据元素长度排序，在根据最后一个提前排序
        list.sortWith(compareBy({ it.length }, { it.last()}))//[one, two, five, four, three]
        Log.e(TAG, "调用sortWith$list")
    }

    fun binaryFun() {
        val list = mutableListOf("one", "two", "three", "four")
        //在查找之前，必须先排序注意排序是sort()不是sorted(),sort()会改变原集合，sorted()不会
        list.sort()
        Log.e(TAG, list.toString())//结果为[four, one, three, two]
        //如果查找到相应元素就返回其索引
        Log.e(TAG, list.binarySearch("two").toString())//结果为3
        //如果没有找到就返回其(-insertionPoint - 1)，其中insertionPoint是应该插入此元素的索引
        //注意是按排序顺序
        Log.e(TAG, list.binarySearch("six").toString())//结果为 -3
        //还可以指定区间去查询，注意是按排序顺序
        Log.e(TAG, list.binarySearch("two", 0, 2).toString())//结果为-3
        //注意如果有多个元素具有给定的值，则搜索可以返回它们的任何索引。
    }
}
