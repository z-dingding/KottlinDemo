package com.hxzk.kottlindemo.classandobject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R

/**
 * Created by OCN.Yang on 2019/9/16. 13:42
 * 作用:属性和字段
 */
class PropertyAndFieleActivity : AppCompatActivity() {

    //已知值的属性可以使用 const 修饰符标记为 编译期常量
    //const val KEY_NAME : String = "123456798"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propertyandfield)
        //Kotlin 类中的属性既可以用关键字 var 声明为可变的，也可以用关键字 val 声明为只读的。
        varAndValMethod()

    }

    /**
     *可以属性和只读属性的定义
     */
    fun varAndValMethod(){
        var variable :String = "aaaaa"
        val immutable : Int =123
    }


    /**
     * 类中get(),set()方法
     */
    class User {
        //定义可为空属性
        var name  : String
        get() = this.name
        set(value) {
            this.name =value
        }
        //定义不可变属性,不可变属性只拥有get()方法
       val age : Int
        get() {
            return age
        }
        //自 Kotlin 1.1 起，如果可以从 getter 推断出属性类型，则可以省略它：
        val isEmpty get() = this.age == 0


    }
}