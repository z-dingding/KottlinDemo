package com.hxzk.kottlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.reference.KeywordWithOperatorActivity
import kotlinx.android.synthetic.main.activity_reference.*

class ReferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reference)

        btn_keyword.setOnClickListener {
            var intent = Intent(this, KeywordWithOperatorActivity::class.java)
            startActivity(intent)
        }
    }
}