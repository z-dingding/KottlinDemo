package com.hxzk.kottlindemo.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class PlusAndMinusOperatorActivity : AppCompatActivity() {

    private  val TAG="PlusAndMinusOperatorActivity"

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plus_and_minus_operator)
        val numbers = listOf("one", "two", "three", "four")
        val numbersTwo = listOf("one", "two")

        val plusList = numbers + "five"
        val plusListTwo = numbers + numbersTwo
        val minusList = numbers - listOf("three", "four")
        val minusListTwo = numbers - numbersTwo

        Log.e(TAG,plusList.toString())//结果为:[one, two, three, four, five]
        Log.e(TAG,plusListTwo.toString())//结果为: [one, two, three, four, one, two]
        Log.e(TAG,minusList.toString())//结果为:[one, two]
        Log.e(TAG,minusListTwo.toString())//结果为: [three, four]

    }
}
