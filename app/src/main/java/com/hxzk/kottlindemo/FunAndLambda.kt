package com.hxzk.kottlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.function_lambda.FunctionActivity
import com.hxzk.kottlindemo.function_lambda.LambdaActivity
import kotlinx.android.synthetic.main.activity_fun_and_lambda.*

class FunAndLambdaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_and_lambda)
        btn_funciton.setOnClickListener {
            startActivity(Intent(this,FunctionActivity :: class.java))
        }
        btn_lambda.setOnClickListener {
            startActivity( Intent(this,LambdaActivity :: class.java))
        }
        btn_innerfunciont.setOnClickListener {  }

    }
}
