package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class ListOverViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_over_view)
        //声明可变集合并打印其中元素
        //listOne()
        //Collection的继承者List和Set,二者都是只读集合，只能进行获取和查询操作
        //声明只读List集合
        //val list = listOf("one","two","three")
        //printCollection(list)
        //声明只读Set集合
        //val set = setOf("ONE","TWO","THREE")
        //printCollection(set)

        //通过打伞将字符串变为集合
        val words = "A long time ago in a galaxy far far away".split(" ")
        val shortWords = mutableListOf<String>()
        //getShortWordsTo是集合内置方法
        words.getShortWordsTo(shortWords, 3)
        println(shortWords)
    }

    fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
        //过滤元素长度小于等于3的重新赋值给shortWords可变集合
        this.filterTo(shortWords) { it.length <= maxLength }
        val articles = setOf("a", "A", "an", "An", "the", "The")
        //应该是去除shortWords中与articles重复的元素
        shortWords -= articles
    }

    /**
     * 声明可变集合并打印其中元素
     */
    fun listOne(){
        //注意即使集合被val修饰，其依然可以add()增加元素,但不能重新赋值
        val numbers = mutableListOf("one", "two", "three", "four")
        numbers.add("five")
        numbers.forEach {
            Log.e("aaaaaaa", it)
        }
        //可变集合可以进行删除操作，返回删除元素值
        var s : String = numbers.removeAt(1)
        for (num in numbers){
            Log.e("aaaaaaa", num)
        }
    }

    /**
     * 打印可变集合Collection的实现类
     */
    fun printCollection( cols : Collection<String>){
        for(col in cols){
            print("$col")
        }
        //换行
        println()

    }

}
