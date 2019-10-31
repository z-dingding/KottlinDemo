package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hxzk.kottlindemo.R
import kotlinx.android.synthetic.main.activity_inner_class.*

class InnerClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inner_class)
        //标记为 inner 的嵌套类能够访问其外部类的成员。内部类会带有一个对外部类的对象的引用
        //内部匿名类：使用对象表达式创建匿名内部类实例：
        textView12.setOnClickListener {

       }
        textView13.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
            }

        })
    }
}
