package com.hxzk.kottlindemo.classandobject

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.hxzk.kottlindemo.R

class ExtensionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extendsion)
        println("Kotlin".lastChar())
    }

    /**
     *自定义String类的的扩展函数，返回这个字符串最后一个字符的方法
     * 需要在你添加的函数名字之前放置你想要扩展的类或者接口的类型。这个类名叫着接收器类型（receiver type），
     * 而你调用的扩展函数的值叫做接收器对象（receiver object）
     * 在此方法中tring是接收器类型，"Kotlin"接收器对象也就是this
     */
    fun String.lastChar() : Char = this.get(this.length - 1)
}
