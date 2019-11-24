package com.hxzk.kottlindemo.classandobject

import android.database.Observable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class EntrustAttributeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrust_attribute)
        //创建委托属性存在的类实例
        var entrustProperty = EntrustProperty()
        //打印内容，本质打印的是getValue函数
        println(entrustProperty.entrustProperty)
        //赋值内容，本质是调用setValue()函数
        entrustProperty.entrustProperty = "给委托属性赋值"


        //可观察属性 Observable
        var mUser = User()
        mUser.name = "张三"
        mUser.name = "李四"
        mUser.name = "王五"
    }
    class User {
        var name: String by Delegates.observable("默认name值为：不知道") { prop, old, new ->
            println("${prop.name} -> $old -> $new")
        }
    }


    class EntrustProperty {
        //将EntrustClass委托给entrustProperty属性
        var entrustProperty: String  by EntrustClass()
    }

    //创建委托类,给委托属性赋值
    class EntrustClass {
        //需要重写getValue方法至少要两个参数，而且第二个参数类型必循是KProperty类型
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "对象类型：$thisRef,对象信息：${property.name} to me!"
        }

        //需要重写setValue方法,至少要三个参数，
        //参数一是:委托属性所在类的类型
        //参数二是：对实例属性自身的描述 （例如你可以取它的名字)。
        //地三个参数是它需要传入的value值
        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("对象类型：$thisRef 对象信息：${property.name} 传入的value值 $value")
        }
    }
}
