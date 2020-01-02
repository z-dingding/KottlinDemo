package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.list.*
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
        btn_interator.setOnClickListener {
            startActivity(Intent(this,InteratorActivity ::class.java))
        }

        btn_intervalAndSequence.setOnClickListener {
            startActivity(Intent(this,IntervalAndSequence ::class.java))
        }
        btn_listOperation.setOnClickListener {
            startActivity(Intent(this,SetOperationActivity ::class.java))
        }
        btn_listReserver.setOnClickListener {
            startActivity(Intent(this,ListReserverActivity ::class.java))
        }
        btn_listFliter.setOnClickListener {
            startActivity(Intent(this,FilterActivity ::class.java))
        }
        tnb_list_plusandminus.setOnClickListener {
            startActivity(Intent(this,PlusAndMinusOperatorActivity ::class.java))
        }
        btn_list_group.setOnClickListener {
            startActivity(Intent(this,GroupActivity ::class.java))

        }
        btn_list_partoflist.setOnClickListener {
            startActivity(Intent(this,getPartListActivity ::class.java))
        }
        btn_list_oneoflist.setOnClickListener {
            startActivity(Intent(this,getOneofListActivity ::class.java))
        }


    }
}
