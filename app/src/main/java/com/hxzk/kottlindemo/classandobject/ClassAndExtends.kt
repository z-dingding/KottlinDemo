package com.hxzk.kottlindemo.classandobject

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R

/**
 * Created by OCN.Yang on 2019/9/16. 15:07
 * 作用:类与继承
 */
class ClassAndExtendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classandextends)
    }


    //注意：如果该类有允许被重写的方法则class要加open,方法也要加
    open class UserBean{
        class UserBean constructor( userName :String){
            init {
                println("init中执行初始化操作")
            }
          var name =userName
        }
        //如果函数没有标注 open ,那么子类不允许重写
        open fun methodOne(){}
          fun methodTwo(){}
    }


    class UserBeanTwo : UserBean(){
        //你想禁止覆盖，使用 final 关键字：
       override fun methodOne(){
        }
    }
}