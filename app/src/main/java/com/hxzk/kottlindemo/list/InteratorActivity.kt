package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class InteratorActivity : AppCompatActivity() {
    private  val TAG = "InteratorActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interator)
        //interatorFun()
        //forMethod()
        //forEachMethod()
        //ListIteratorMethod()
        //可变集合迭代器删除和修改元素值
        //mutableListMethod()
    }

    /**
     * 可变集合可变迭代器删除和修改元素值
     * listIterator返回的迭代器允需增加和删除操作
     * Iterator返回的迭代器只能执行删除操作
     */
    private fun mutableListMethod() {
        val numbers = mutableListOf("one", "two", "three", "four")
        //获取可变集合的迭代器
        val mutableList =numbers.listIterator()
        mutableList.next()
        mutableList.remove()
        //测试发现，不管是remove()还是set()上一个方法必须是next()，next获取元素值后才能进行remove()或set()
        mutableList.next()
        mutableList.set("five")

        println("打印集合内容$numbers")
    }

    /**
     * 对于列表，有一个特殊的迭代器实现:ListIterator。
     * 它支持在两个方向上迭代列表:向前和向后。向后迭代由函数hasPrevious()和previous()实现。
     * 此外，ListIterator使用nextIndex()和previousIndex()函数提供关于元素索引的信息。
     */
    private fun ListIteratorMethod() {
        val numbers = listOf("one", "two", "three", "four")
        //获取listIterator迭代器
        val listIterator = numbers.listIterator()
        //判断如果迭代器有下一个元素就获取打印
        while (listIterator.hasNext()){
            println("打印迭代器内容${listIterator.next()}")
        }
      //判断迭代器是否能从后往前打印，估计再次从前往后打印是不可能了因为迭代器已经从前往后执行过一次了
        while (listIterator.hasPrevious()) {
            //从后往前打印索引值
            print("Index: ${listIterator.previousIndex()}")
            //从后往前打印每一个元素值
            println(", value: ${listIterator.previous()}")
        }
    }

    /**
     * 调用forEach方法遍历集合
     */
    fun forEachMethod(){
        val numbers = listOf("one", "two", "three", "four")
        numbers.forEach {
            Log.e(TAG, "调用forEach打印元素$it")
        }
    }
    /**
     * 使用for循环遍历集合
     */
    fun forMethod(){
        val numbers = listOf("one", "two", "three", "four")
        for(num in numbers){
            Log.e(TAG, "调用for循环打印元素$num")
        }
    }
    /**
     * 迭代器方法遍历集合
     */
    fun interatorFun(){
        val numbers = listOf("one", "two", "three", "four")
        //调用iterator()函数，可以为Iterable接口的继承者(包括Set和List)获得迭代器
        val numbersIterator = numbers.iterator()
        //它将指向集合的第一个元素;调用next()函数将返回此元素，并将迭代器位置移动到存在的下一个元素
        var listOne =numbersIterator.next()
        Log.e(TAG,"调用next获取迭代器第一个元素$listOne")
        var listTwo =numbersIterator.next()
        Log.e(TAG, "再次调用next获取迭代器第二个元素$listTwo")
        //迭代器一旦遍历最后一个元素，就不能再用于检索元素;它也不能重置到以前的任何位置。
        // 若要再次遍历集合，请创建一个新的迭代器
        while (numbersIterator.hasNext()) {
            Log.e(TAG, "迭代器调用next打印元素${numbersIterator.next()}")
        }
    }
}
