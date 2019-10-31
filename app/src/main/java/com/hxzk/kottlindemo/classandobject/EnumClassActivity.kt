package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R

class EnumClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enum_class)
       //根据valueOf获取指定枚举
        var enum = EnumClass.valueOf("BLEW")
        println(enum.name +":"+enum.height)
        //根据values获取枚举数组
        var arrEnum =EnumClass.values()
        println(arrEnum.joinToString {it.name+":"+it.height})
    }


    enum class EnumClass(val height:Int){
        BLEW(150) ,
        MIDDLE(170),
        HEIGHT(185)
    }
}
