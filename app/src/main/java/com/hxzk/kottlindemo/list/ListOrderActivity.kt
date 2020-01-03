package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class ListOrderActivity : AppCompatActivity() {
 private val TAG ="ListOrderActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_order)
        //comparable比较对象大小
        //comparableFun()
        //用comparator(比较器)比较对象
        //comparatorFun()
        //自定义顺序排序
        //sortFun()
        //倒序排序
        //reverseFun()
        //随机顺序
        shuffledFun()
    }

    /**
     * 用shuffled进行随机排序
     */
    fun shuffledFun(){
        val numbers = listOf("one", "two", "three", "four")
        Log.e(TAG,numbers.shuffled().toString())//结果为:[four, one, two, three]
        Log.e(TAG,numbers.shuffled().toString())//结果为:[four, two, one, three]
        Log.e(TAG,numbers.shuffled().toString())//结果为:[three, two, one, four]
    }
    /**
     * 倒序排序
     */
    fun reverseFun(){
        val list = mutableListOf("one","three","two","seven")
        //用reversed()函数进行倒序
        Log.e(TAG,list.reversed().toString())//结果为:[seven, two, three, one]
        //用asReversed()函数进行倒序,如果集合改变，倒序结果也会改变
        val asReversedList =list.asReversed()
        Log.e(TAG,asReversedList.toString())//结果为:[seven, two, three, one]
        list.add("four")
        Log.e(TAG,asReversedList.toString())//结果为:[four, seven, two, three, one]
    }
    /**
     * 自定义顺序
     */
    fun sortFun(){
        val list = listOf<String>("one","three","two","seven")
        //用sortedBy()自定义排序顺序
        Log.e(TAG,list.sortedBy {  it.length}.toString())//结果为：[one, two, three, seven]
        //用sortedByDescending()根据方法处理结果进行降序排序
        Log.e(TAG,list.sortedByDescending { it.length }.toString())//结果为：[three, seven, one, two]
    }
    /**
     * 集合排序，用comparator(比较器)比较对象
     */
    fun comparatorFun(){
        val list = listOf<String>("one","three","two","seven")
        //定义长度比较器
        val lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }
        Log.e(TAG,list.sortedWith(lengthComparator).toString()) //结果为:[one, two, three, seven]
        //自定义的长度比较器可以通过使用compareBy()实现同样效果
        Log.e(TAG, list.sortedWith(compareBy{ it.length }).toString())//结果为:[one, two, three, seven]
    }


    /**
     * 集合排序，用comparable比较对象
     */
    fun comparableFun(){
        var versionOne =Version(1,2)
        var versionTwo =Version(3,4)
        //versionOne > versionTwo 本质上调用的是versionOne.compareTo(versionTwo)
        Log.e(TAG,(versionOne > versionTwo).toString())//结果为:false
    }
    class Version(val major: Int, val minor: Int): Comparable<Version> {
        override fun compareTo(other: Version): Int {
            if (this.major != other.major) {
                return this.major - other.major
            } else if (this.minor != other.minor) {
                return this.minor - other.minor
            } else return 0
        }
    }
}
