package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class GroupActivity : AppCompatActivity() {

    private  val TAG ="GroupActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)


        val list = listOf("java","javaScript","php","kotlin")
        val groupListOne =list.groupBy { it.startsWith("java") }
        Log.e(TAG,groupListOne.toString())//结果为:{true=[java, javaScript], false=[php, kotlin]}
        Log.e(TAG, groupListOne.get(true).toString())//结果为:[java, javaScript]
        Log.e(TAG, groupListOne.get(false).toString())//结果为: [php, kotlin]
        val listgroup=list.groupBy { if (it.startsWith("java")) "big" else "latter" }
        Log.e(TAG,listgroup.get("big").toString())//结果为:[java, javaScript]
        Log.e(TAG,listgroup.get("latter").toString())//结果为:[php, kotlin]
        //以元素长度大于4，进行分组
        val groupingByList =list.groupingBy {  it.length > 4 }
        //获取每组个数
        var size =groupingByList.eachCount()
        Log.e(TAG,size.toString())//结果为:{false=2, true=2}
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        //以首字母一致分组，并获取每组信息
        println(numbers.groupingBy { it.first() }.eachCount()) //{o=1, t=2, f=2, s=1}

    }
}
