package com.hxzk.kottlindemo.classandobject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R

/**
 * Created by OCN.Yang on 2019/9/26. 21:59
 * 作用:接口
 */
class InterfaceActivity : AppCompatActivity() ,MyInterface {
    override fun OneMethod() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun TwoMethod() {
        super.TwoMethod()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface)
    }

}