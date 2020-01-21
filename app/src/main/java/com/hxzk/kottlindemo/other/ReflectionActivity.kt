package com.hxzk.kottlindemo.other

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R
import com.hxzk.kottlindemo.bean.UserBean
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberFunctions

class ReflectionActivity : AppCompatActivity() {


    private val TAG = "ReflectionActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reflection)
        //最基本的反射功能是获取 Kotlin 类的运行时引用,该引用是 KClass 类型的值
        //方式一：通过对象获取Class实例
        val userBean = UserBean::class.java
        //方式二通过类::class的方式获取Kclass实例
        val clazz: KClass<*> = UserBean::class
        //其他反射方法:返回这个类可访问的所有函数和属性，包括继承自基类的，但是不包括构造器
        val listMember = clazz.members
        //其他反射方法:返回其自身声明的函数
        val listProperty = clazz.declaredMemberFunctions

        val initUser = UserBean("张三", 20, "垣曲")
        val initClazz = initUser.javaClass.kotlin
        //返回这个类可访问的所有函数和属性并打印
        val list = initClazz.members

        //调用了类中相关方法toString()
        val function1 = UserBean::toString
        val toStringFun =function1.invoke(initUser)//已经调用一次
        Log.e(TAG,"$toStringFun")//结果为:my name is 张三,20 year old ,from 垣曲

        //你也可以反射调用属性的getter和setter：
        val ageP = UserBean::mAge
        //通过set()调用(安全),重新赋值
        ageP.set(initUser, 24)
        //通过get调用(安全）
        val age =ageP.get(initUser)
        Log.e(TAG,"$age")//结果为:24
    }
}
