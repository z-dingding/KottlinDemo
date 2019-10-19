package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R

class DataBeanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databean)
        var mAccountBean = AccountBean("zhangsan", 18, "垣曲县古城镇")
        var mAccountBeanTwo = AccountBeanTwo("lisi", 28, "垣曲县古城镇")
            mAccountBeanTwo.phone = 1234567222
        //在很多情况下，我们需要复制一个对象改变它的一些属性，但其余部分保持不变。 copy() 函数就是为此而生成
        var mAccountBeanThree =mAccountBeanTwo.copy(name = "王五",address = "垣曲县毛家镇")
        println(mAccountBean.toString())
        println(mAccountBeanTwo.toString())
        println(mAccountBeanThree.toString())
    }
//如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。
//如果构造函数通过在类名上创建则那么每一个Kotlin类只有一个构造函数(没有constructer) 没有多个构造函数
    data class AccountBean(var name: String = "null", var age: Int = 0, var address: String = "null")
    data class AccountBeanTwo(var name: String, var age: Int, var address: String) {
        //如需在生成的实现中排出一个属性，请将其声明在类体中
        var phone: Int = 132456789
    }
}
