package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R

/**
 * 可见修饰符
 */


//注意作用域从大到小为public->internal->protect->private
//默认为 public，这意味着你的声明将随处可见，可以不写
public fun oneMethod(){}
//如果你声明为 internal，它会在相同模块内随处可见
internal fun twoMethod(){}
//protected 不适用于顶层声明，会报错
 fun threeMethod(){}
//如果你声明为 private，它只会在声明它的文件内可见
private fun fourMethod(){}

class VisiableModifierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visiablemodifier)
    }
}
