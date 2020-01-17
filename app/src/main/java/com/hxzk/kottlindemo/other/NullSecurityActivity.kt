package com.hxzk.kottlindemo.other

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class NullSecurityActivity : AppCompatActivity() {

    private val TAG = "NullSecurityActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_security)
        //避免NullPointException用?.
        //nullsecurity()
        //Elvis操作符
        elvisFun()
    }

    fun elvisFun() {
        var one ="dddddddddd"
        var sVariable :Int = if(one != null) one.length else 100
        Log.e(TAG,"$sVariable")
        //上面的表达式可以用elvis实现 写作 ?:
        var two : String? =null
        var sVariableTwo = two?.length ?: -1
        Log.e(TAG,"$sVariableTwo")
    }

    fun nullsecurity() {
        //如，在String类型的常规变量中是不允许变量为null的，必须进行初始化,如果非要为null，则如下写法:
        var sVariable: String? = null
        //因为sVariable变量为null,第二个选择是安全调用操作符，写作 ?.
        //如果 b 非空，就返回 b.length，否则返回 null，这个表达式的类型是 Int?
        Log.e(TAG, "${sVariable?.length}")//结果为:null
        //如果要只对非空值执行某个操作，安全调用操作符可以与 let 一起使用
        val list: List<String?> = listOf("张三", "李四", null, "赵六")
        for (item in list) {
            //与 let 一起使用过滤了为null的元素
            item?.let { Log.e(TAG, item) }//结果为:张三,李四,赵六
        }
        //安全调用也可以出现在赋值的左侧。
        // 这样，如果调用链中的任何一个接收者为空都会跳过赋值，而右侧的表达式根本不会求值：
        //person?.department?.head = managersPool.getManager()
    }
}
