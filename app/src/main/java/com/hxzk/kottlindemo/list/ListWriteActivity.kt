package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class ListWriteActivity : AppCompatActivity() {

    private  val TAG ="ListWriteActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_write)
        //集合的添加操作
        //listAdd()
        //集合的删除操作
        //listRemove()
        //集合的修改操作
        //listUpdate()
    }

    fun listUpdate(){
        //列表和集合还提供了更新元素的操作。它们在列表特定操作和映射特定操作中进行了描述。对于集合，更新是没有意义的，因为它实际上是删除一个元素并添加另一个元素
    }
    fun listRemove(){
        val mutableList = mutableListOf<Int>(1,2,3,4,5)
        //remove()参数是移除指定的元素值元素而不是下标元素
        mutableList.remove(3)
        Log.e(TAG,mutableList.toString())//结果为:[1, 2, 4, 5]
        //removeAll()删除参数集合中出现的所有元素
        mutableList.removeAll(listOf(4,5))
        Log.e(TAG,mutableList.toString())//结果为:[1, 2]
        //retainAll()是removeAll()的反义词:它删除除参数集合中的元素之外的所有元素
        mutableList.retainAll(listOf(1))
        Log.e(TAG,mutableList.toString())//结果为:[1]
        //clear()删除列表中的所有元素，并将其保留为空
        mutableList.clear()
        Log.e(TAG,mutableList.toString())//结果为:[]

        val numbers = mutableListOf("one", "two", "three", "three", "four")
        numbers -= "three"
        //如果有两个重复元素，则删除它的第一次出现
        Log.e(TAG,numbers.toString())//结果为:[one, two, three, four]
        numbers -= listOf("four", "five")
        Log.e(TAG,numbers.toString())//结果为:[one, two, three]
    }
    fun listAdd(){
        val mutableList = mutableListOf<Int>(1,2,3,4,5)
        mutableList.add(6)
        //添加数组到集合
        mutableList.addAll(arrayOf(7,8))
        //添加集合到指定下标位置
        mutableList.addAll(2, listOf(9,10))
        Log.e(TAG,mutableList.toString())//结果为:[1, 2, 9, 10, 3, 4, 5, 6, 7, 8]
        //+=相当于将第二个操作数(一个元素或另一个集合)附加到集合的末尾
        mutableList += 11
        Log.e(TAG,mutableList.toString())//结果为:[1, 2, 9, 10, 3, 4, 5, 6, 7, 8, 11]
    }
}
