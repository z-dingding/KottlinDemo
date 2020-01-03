package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class getOneofListActivity : AppCompatActivity() {

    private  val TAG ="getOneofListActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_oneof_list)
        //按位获取set集合单个元素
        //elementAtFun()
        //按条件获取set集合单个元素
        //fistwithlastFun()
       //随机获取set集合单个元素
        //randomFun()
        //判断集合是否有元素和包含指定元素或元素集合
        //containFun()
    }

    /**
     *检测存在与否
     */
    fun containFun(){
        val setList = linkedSetOf("one", "two", "three", "four", "five")
        //判断是否包含指定元素
        Log.e(TAG,setList.contains("one").toString())//结果为：true
        Log.e(TAG,("one" in setList).toString())//结果为：true
        //判断是否包含指定元素集合
        Log.e(TAG,(setList.containsAll(setOf("three","seven"))).toString())//结果为：false

        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.isEmpty()) //结果为:false
        println(numbers.isNotEmpty())//结果为:true

        val empty = emptyList<String>()
        println(empty.isEmpty())//结果为:true
        println(empty.isNotEmpty())//结果为:false
    }
    /**
     * 随机获取集合某个元素
     */
    fun randomFun(){
        val setList = linkedSetOf("one", "two", "three", "four", "five")
        Log.e(TAG,setList.random())//结果不确定
    }

    /**
     * 按条件获取单个元素
     */
    fun fistwithlastFun(){
        val setList = linkedSetOf("one", "two", "three", "four", "five")
        //fist()按条件从前往后查找第一个
        Log.e(TAG,setList.first())//结果为：one
        Log.e(TAG,setList.first { it.length >3 })//结果为：three
        //last()按条件从后往前查找第一个
        Log.e(TAG,setList.last() { it.length >3 })//结果为：five

        //find()和findLast()同first和last()结果一致
        Log.e(TAG,setList.first { it.length >3 })//结果为：three
        Log.e(TAG,setList.last() { it.length >3 })//结果为：five

        //为了防止下标越界，建议firstOrNull()或lastOrNull()
        Log.e(TAG,"建议firstOrNull测试"+setList.firstOrNull() { it.length >10 })//结果为：建议firstOrNull测试null
        Log.e(TAG,"或lastOrNull测试"+setList.lastOrNull { it.length >10 })//结果为：或lastOrNull测试null

    }

    /**
     * 按位置取elementAt()
     */
    fun elementAtFun(){
        //set集合不提供get()方法
        val setList = linkedSetOf("one", "two", "three", "four", "five")
        Log.e(TAG,setList.toString())//结果为:[one, two, three, four, five]
        Log.e(TAG,setList.elementAt(3))//结果为:four

        val sortSet = sortedSetOf("one", "two", "three", "four", "five")
        Log.e(TAG,sortSet.toString())//结果为:[five, four, one, three, two]
        Log.e(TAG,sortSet.elementAt(3))//结果为:three

        //为了避免在检索不存在位置的元素时出现异常,可以使用elementAtOrNull或elementAtOrElse()
        //Log.e(TAG,setList.elementAt(5)) //会出错
        //当指定的位置超出集合边界时，elementAtOrNull()返回null
        var element =setList.elementAtOrNull(5)
        Log.e(TAG,"结果为:"+element) //结果为:结果为:null
        //当使用出界位置调用时，elementAtOrElse()将返回给定值上的结果。
        Log.e(TAG,setList.elementAtOrElse(5){ indexValue -> "default"})//结果为: default

    }
}
