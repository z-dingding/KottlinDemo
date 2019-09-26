package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.start.base.VarAndFunActivity
import com.hxzk.kottlindemo.start.codespecification.CodeSpecificationActivity
import com.hxzk.kottlindemo.start.habitusage.HabitUsageActivity
import kotlinx.android.synthetic.main.activity_start.*

/**
 * 作者：Created by ${XZT} on 2019/9/1
文件描述：开始
 */
class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        btn_main_funandvar.setOnClickListener {
            var intent = Intent(this, VarAndFunActivity::class.java)
            startActivity(intent)
        }


        btn_main_habitusage.setOnClickListener {
            var habitusage = Intent(this, HabitUsageActivity::class.java)
            startActivity(habitusage)
        }

        btn_main_codespecification.setOnClickListener {
            var codeSpecificaton = Intent(this, CodeSpecificationActivity::class.java)
            startActivity(codeSpecificaton)
        }
    }
}