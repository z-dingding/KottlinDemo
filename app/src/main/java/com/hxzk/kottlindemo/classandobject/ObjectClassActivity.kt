package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hxzk.kottlindemo.R
import kotlinx.android.synthetic.main.activity_object_class.*

class ObjectClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_class)

        tv_object_one.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
            }

        })
    }
}
