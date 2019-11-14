package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R

//声明内联类，注意参数修饰为val
inline class InlineClass(val params: String) {
    //内联类支持普通类中的一些功能。特别是，内联类可以声明属性与函数：
    //但内联类不能含有 init 代码块，内联类不能含有幕后字段
    //同时内联类允许去继承接口，但内联类不能继承其他的类而且必须是 final
    //val不能有set方法
    val name: String
        get() = params

    //内联类中定义方法
    fun priltParams() {
        println("params== $name")
    }
}

//内联类
class InlineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inline)
        //内联类必须含有唯一的一个属性在主构造函数中初始化。在运行时，将使用这个唯一属性来表示内联类的实例
        val inlineClass = InlineClass("唯一属性来表示内联类的实例")
    }


}
