package com.hxzk.kottlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.classandobject.*
import kotlinx.android.synthetic.main.activity_classandobject.*

/**
 * Created by OCN.Yang on 2019/9/16. 13:32
 * 作用:
 */
class ClassAndObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classandobject)
        btn_propertyandfiele.setOnClickListener{
          var propertyAndFiele = Intent(this,PropertyAndFieleActivity :: class.java)
            startActivity(propertyAndFiele)
        }
        btn_classandextends.setOnClickListener{
            var classAndExtend =Intent(this,ClassAndExtendsActivity::class.java)
            startActivity(classAndExtend)
        }

        btn_interface.setOnClickListener{
            var intface =Intent(this,InterfaceActivity ::class.java)
            startActivity(intface)
        }

        btn_visiablemodifier.setOnClickListener {
            var intface =Intent(this,VisiableModifierActivity ::class.java)
            startActivity(intface)
        }
        btn_extension.setOnClickListener {
            var extensionIntent = Intent(this,ExtensionActivity ::class.java)
            startActivity(extensionIntent)
        }
        btn_databean.setOnClickListener {
            var databean = Intent(this,DataBeanActivity ::class.java)
            startActivity(databean)
        }

    }
}