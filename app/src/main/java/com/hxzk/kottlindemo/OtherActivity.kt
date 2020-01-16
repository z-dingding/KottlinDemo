package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.other.DeconstructionStatementActivity
import com.hxzk.kottlindemo.other.ThisActivity
import com.hxzk.kottlindemo.other.TypeCheckWithTransLationActivity
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        btn_other_deconstruction.setOnClickListener {
            startActivity(Intent(this, DeconstructionStatementActivity :: class.java ))
        }
        btn_other_typecheck.setOnClickListener {
            startActivity(Intent(this, TypeCheckWithTransLationActivity :: class.java ))
        }
        btn_other_this.setOnClickListener {
            startActivity(Intent(this, ThisActivity :: class.java ))
        }
    }

}
