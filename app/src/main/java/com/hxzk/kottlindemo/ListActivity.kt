package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.list.ConstructorListActivity
import com.hxzk.kottlindemo.list.ListOverViewActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btn_listOverView.setOnClickListener {
            startActivity(Intent(this,ListOverViewActivity :: class.java))
        }
        btn_constructorList.setOnClickListener {
            startActivity(Intent(this,ConstructorListActivity ::class.java))
        }
    }
}
