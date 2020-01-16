package com.hxzk.kottlindemo.other

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class DeconstructionStatementActivity : AppCompatActivity() {

    private  val TAG ="DeconstructionStatementActivity"

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deconstruction_statement)
        //使用解构变量，同时创建多个变量
        val ( name ,age ) =User("张三",20)
        Log.e(TAG,"$name")//结果为:张三
        Log.e(TAG,"$age")//结果为:20
        //使用结构变量相当于下面调用
        var user =User("李四",26)
        var one = user.component1()
        var two= user.component2()
        Log.e(TAG,"$one")//结果为:李四
        Log.e(TAG,"$two")//结果为:26
    }
    //声明数据类
    data class User(val name :String ,val age :Int)
}
