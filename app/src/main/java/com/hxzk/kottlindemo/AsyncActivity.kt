package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.Coroutines.CoroutinesBasicActivity
import com.hxzk.kottlindemo.Coroutines.CoroutinesCancelWithTimeOutActivity
import com.hxzk.kottlindemo.Coroutines.CoroutinesGuideActivity
import com.hxzk.kottlindemo.Coroutines.CoroutinesHangUpFunActivity
import kotlinx.android.synthetic.main.activity_async.*

class AsyncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
        btn_coroutinesGuide.setOnClickListener {
            val intent =Intent(this,CoroutinesGuideActivity  ::class.java)
            startActivity(intent)
        }

        btn_coroutinesBasic.setOnClickListener {
            val intent =Intent(this,CoroutinesBasicActivity  ::class.java)
            startActivity(intent)
        }

        btn_coroutines_cancelwithtimeout.setOnClickListener {
            val intent =Intent(this, CoroutinesCancelWithTimeOutActivity  ::class.java)
            startActivity(intent)
        }
        btn_coroutines_hangupfun.setOnClickListener {
            val intent =Intent(this,CoroutinesHangUpFunActivity  ::class.java)
            startActivity(intent)
        }
    }
}
