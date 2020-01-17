package com.hxzk.kottlindemo.other

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R

class OpratorOverloadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oprator_overloading)
        // 重载操作符的函数需要用 operator 修饰符标记
    }
}
