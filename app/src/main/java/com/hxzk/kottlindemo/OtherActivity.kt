package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.other.*
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
        btn_other_equal.setOnClickListener {
            startActivity(Intent(this, EqualActivity :: class.java ))
        }
        btn_other_opratoroverloading.setOnClickListener {
            startActivity(Intent(this, OpratorOverloadingActivity :: class.java ))
        }
        btn_other_nullsecurity.setOnClickListener {
            startActivity(Intent(this, NullSecurityActivity :: class.java ))
        }
        btn_other_excaption.setOnClickListener {
            startActivity(Intent(this, ExceptionActivity :: class.java ))
        }
        btn_other_annotation.setOnClickListener {
            startActivity(Intent(this, AnnotationActivity :: class.java ))
        }
        btn_other_reflect.setOnClickListener {
            startActivity(Intent(this, ReflectionActivity :: class.java ))
        }
        btn_other_scope.setOnClickListener {
            startActivity(Intent(this, ScopeActivity :: class.java ))
        }
    }

}
