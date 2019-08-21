package com.hxzk.kottlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.base.VarAndFunActivity
import com.hxzk.kottlindemo.habitusage.HabitUsageActivity
import kotlinx.android.synthetic.main.activity_main.btn_main_funandvar
import kotlinx.android.synthetic.main.activity_main.btn_main_habitusage

class MainActivity : AppCompatActivity() {


   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_main_funandvar.setOnClickListener{
            var intent : Intent =Intent(this,VarAndFunActivity::class.java)
            startActivity(intent)
       }


       btn_main_habitusage.setOnClickListener{
           var habitusage =Intent(this,HabitUsageActivity::class.java)
           startActivity(habitusage)
       }

    }
}
