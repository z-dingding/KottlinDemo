package com.hxzk.kottlindemo.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.hxzk.kottlindemo.R

class SetAboutOperationActivity : AppCompatActivity() {

    private  val TAG ="SetAboutOperationActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_abouty_operation)
        setOperationFun()
    }


    @SuppressLint("LongLogTag")
    fun setOperationFun(){
        val setColsOne = setOf(1,2,3,4,5,5,9)
        val setColsTwo = setOf(1,2,3,4,5,6,7,8)
        //union函数取并集，有序集合左侧操作数在前.也能以中缀形式使用 a union b
        Log.e(TAG,setColsOne.union(setColsTwo).toString())//[1, 2, 3, 4, 5, 9, 6, 7, 8]
        //交集请用intersect(),也能以中缀形式使用 a union b
        Log.e(TAG,(setColsOne intersect setColsTwo).toString())//[1, 2, 3, 4, 5]
        //差集用subtract()，也能以中缀形式使用 a union b,注意也是后一个比前一个差那些元素。
        Log.e(TAG,(setColsOne subtract setColsTwo).toString())//[9]
    }
}
