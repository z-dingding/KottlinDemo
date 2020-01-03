package com.hxzk.kottlindemo.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hxzk.kottlindemo.R

class SequenceActivity : AppCompatActivity() {
    private   val TAG="SequenceActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sequence)
        //创建序列
        val sequence = sequenceOf("张三","李四","王五","赵六")
        //如果已有一个Iterable对象（例如a List或a Set），则可以通过调用asSequence()从中创建一个序列
        val list = listOf("张三","李四","王五","赵六")
        val listSequence =list.asSequence()
        //创建序列的另一种方法是通过使用generateSequence函数来构建序列
        //必须显示自定第一个元素,我们暂时设定为1
        val infiniteSequence= generateSequence (1){if (it < 10) it + 2 else null }
        //调用count()查看序列的长度，结果为：查看序列长度6
        Log.e(TAG,"查看序列长度${infiniteSequence.count()}")
        //调用.take().toList()去打印序列元素，结果为：查看序列长度[1, 3, 5, 7, 9, 11]
        Log.e(TAG,"查看序列长度${infiniteSequence.take(infiniteSequence.count()).toList()}")
        //含yield()和yieldAll()函数可以将一个元素返回给序列使用者，并暂停执行sequence()直到该使用者请求下一个元素
        //yield()以单个元素作为参数；yieldAll()可以带一个或另一个Iterable对象。的参数可以是无限的。
        //  但是，这样的调用必须是最后一个：以后的所有调用将永远不会执行。
    }
}
