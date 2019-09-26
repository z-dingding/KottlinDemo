package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.base.BackAndJumpActivity
import com.hxzk.kottlindemo.base.BaseTypeActivity
import com.hxzk.kottlindemo.base.ControlStreamActivity
import com.hxzk.kottlindemo.base.PackageAndImportActivity
import kotlinx.android.synthetic.main.activity_base.*

/**
 * 作者：Created by ${XZT} on 2019/9/1
文件描述：基础
 */
class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        btn_base_basetype.setOnClickListener {
            var baseType =Intent(this,BaseTypeActivity :: class.java)
            startActivity(baseType)
        }
        btn_base_packageandimport.setOnClickListener {
            var packageIntetnt =Intent(this,PackageAndImportActivity :: class.java)
            startActivity(packageIntetnt)
        }
        btn_base_clontrolstream.setOnClickListener {
            var controlStreamActivity =Intent(this,ControlStreamActivity :: class.java)
            startActivity(controlStreamActivity)
        }
        btn_base_baseandjump.setOnClickListener {
            var backAndJumpActivity =Intent(this,BackAndJumpActivity :: class.java)
            startActivity(backAndJumpActivity)
        }
    }
}