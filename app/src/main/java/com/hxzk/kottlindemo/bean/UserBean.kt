package com.hxzk.kottlindemo.bean

import android.util.Log


//普通类的创建和使用
 class  UserBean{
    private  val TAG ="ReflectionActivity"
    var mName ="null"
    var mAge =0
    var mAddress ="null"
    //主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块中
    constructor()
    /**
     * 1. 多重构造函数需要有一个主函数，和N个次函数
     * 2. 次函数将委托给主函数
     * 3. 委托关系用this关键词表示
     */
     //次构造函数,次构造函数不能有声明 val 或 var
     constructor( name :String , age :Int,address :String) : this() {
        this.mName =name
        this.mAge =age
        this.mAddress =address
     }
    override fun toString(): String {
        Log.e(TAG, "my name is $mName,$mAge year old ,from $mAddress")
        return "my name is $mName,$mAge year old ,from $mAddress"
    }
 }




