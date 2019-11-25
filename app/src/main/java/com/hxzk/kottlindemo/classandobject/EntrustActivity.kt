package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R

class EntrustActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrust)
        //调用执行
        var msg ="打印委托内容"
        var baseImpl =BaseImpl(msg)
        var derived =Derived(baseImpl)
        //委托类可以覆盖实现类的函数
        derived.printMethod()
        derived.printMethodTwo()
        //委托类无法覆盖实现类的成员属性
        println(derived.msg)
    }
   //定义Base接口
    interface Base{
       val msg : String
       fun printMethod()
       fun printMethodTwo()
   }
    //Base接口实现类 BaseImpl，并重写相关方法
    class BaseImpl(var printContent : String) :Base{
        override val msg: String ="BaseImpl"
        override fun printMethodTwo() {println("printMethodTwo打印内容:$printContent")}
         override fun printMethod() {println("printMethod打印内容:$printContent") }
    }
    //通过by将Base的相关方法委托给Derived类，允许其调用执行
    //by b含义：标识b将会在Derived内部存储，并且编译器将Base的所有方法委托给b。
    class Derived(b : Base) :Base by b{
        override val msg: String ="Derived"
        //委托类也实现了改方法，则实现类中就会被覆盖
        override fun printMethod() {println("Derived打印内容：11111111") }
    }











}
