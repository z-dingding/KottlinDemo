package com.hxzk.kottlindemo.other

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hxzk.kottlindemo.R
import com.hxzk.kottlindemo.bean.DataUserBean

/**
Autour: ${zjt}
Date: ${DATE}
Description:作用域函数
 **/
class ScopeActivity : AppCompatActivity() {
    private val TAG = "ScopeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope)
        //使用let作用域函数的经典案例
       // letFun()
        //this与it的区别
        //thisItFun()
        //作用域区别之一返回值
        returnFun()
    }

    /**
     *  作用域区别之一返回值
     */
    fun returnFun(){
        var str  ="hello world"
       //apply 及 also 返回上下文对象
        var startStr=str.apply {
            Log.e(TAG, "${this.length+5}")//结果为:16
        }
        Log.e(TAG, "${startStr.length}")//结果为:11
        //let、run 及 with 返回 lambda 表达式结果.
        val list = mutableListOf("1","2","3")
        var endStr=list.run {
          add("4")
          add("5")
            //count()函数计算列表中符合条件的元素的数量并返回
            count { it.endsWith("5") }
        }
        Log.e(TAG, "$endStr")//结果为:1
        Log.e(TAG, "$list")//结果为:[1, 2, 3, 4, 5]
    }

    /**
     * 作用域区别之一,引用上下文对象this还是it
     */
    fun thisItFun(){
        var str ="scope"
        //run、with 以及 apply 通过关键字 this 引用上下文对象。
        str.run {
            Log.e(TAG, "${this.length}")//结果为:5
            //也可以省略 this
            Log.e(TAG, "$length")//结果为:5

        }
        //let 及 also 将上下文对象作为 lambda 表达式参数
        str.let {
            Log.e(TAG, "${it.length}")//结果为:5
        }
    }


    /**
     * 使用let函数的经典案例
     */
    fun letFun() {

        DataUserBean("张三", 18, "毛家镇").let {
            Log.e(TAG, it.toString())//结果为: DataUserBean(name=张三, age=18, address=毛家镇)
            it.name = "李四"
            Log.e(TAG, it.toString())//结果为: DataUserBean(name=李四, age=18, address=毛家镇)
        }
    }
}
