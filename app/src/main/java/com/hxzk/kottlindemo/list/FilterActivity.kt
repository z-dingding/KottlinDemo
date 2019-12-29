package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class FilterActivity : AppCompatActivity() {
    private val TAG="FilterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        //filter条件过滤
        //map()
        // partition条件过滤
        partitionMethod()
    }


    fun map(){
        val mapList = mapOf("one1" to 1 ,"two2" to 2,"three3" to 30,"four4" to 21,"five3" to 31)
        //filter()中的谓词只能检查元素的值,
        //过滤key以3结尾，value值大于20的,下面结果为： {three3=30, five3=31}
        val mapFilterList =mapList.filter { (key ,value) ->key.endsWith("3") && value > 20}
        Log.e(TAG,mapFilterList.toString())
        //filterIndexed可以筛选元素位置:索引和元素的值
        val list = listOf("one","two","three")
        val  mapFilterIndexList =list.filterIndexed { index, s ->index != 0 && s.length >3  }
        Log.e(TAG,mapFilterIndexList.toString())//下面结果为：[three]
        //使用filterNot()过滤相反条件集合
        val filterNotList =list.filterNot { it.length > 3 }
        Log.e(TAG,filterNotList.toString())//下面结果为：[one, two]
        //filterIsInstance()返回给定类型的集合元素
        val numbers = listOf(null, 1, "two", 3.0, "four")
        //过滤出string类型的集合
        val  stringList =numbers.filterIsInstance<String>()
        Log.e(TAG,stringList.toString())//下面结果为：[two, four]
        //filterNotNull()返回所有非空元素
        val  notNullList=numbers.filterNotNull()
        Log.e(TAG,notNullList.toString())//下面结果为：[1, two, 3.0, four]
    }

    fun partitionMethod(){
        val numbers = listOf("one", "two", "three", "four")
        val (match, rest) = numbers.partition { it.length > 3 }
        Log.e(TAG,match.toString())//下面结果为：[three, four]
        Log.e(TAG,rest.toString())//下面结果为：[one, two]
    }
}
