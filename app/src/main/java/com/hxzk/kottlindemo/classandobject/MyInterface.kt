package com.hxzk.kottlindemo.classandobject

/**
 * Created by HaiyuKing
 * Used
 */
interface MyInterface {
    fun OneMethod()
    fun TwoMethod(){
        //接口中可以有方法体,有方法体的子类不会主动实现
        var a =124;
    }
}