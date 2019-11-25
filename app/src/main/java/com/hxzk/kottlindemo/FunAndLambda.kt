package com.hxzk.kottlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fun_and_lambda.*

class FunAndLambdaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_and_lambda)
        btn_funciton.setOnClickListener {  }
        btn_lambda.setOnClickListener {  }
        btn_innerfunciont.setOnClickListener {  }

    }
}
