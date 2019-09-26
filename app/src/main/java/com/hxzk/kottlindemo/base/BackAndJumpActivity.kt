package com.hxzk.kottlindemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R

/**
 * 作者：Created by ${XZT} on 2019/9/1
文件描述：
 */
class BackAndJumpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backandjump)
//        return。默认从最直接包围它的函数或者匿名函数返回。
//        break。终止最直接包围它的循环。
//        continue。继续下一次最直接包围它的循环
        //在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号
        xunHuanMethod(num =*intArrayOf(1,5,8,3,7))

    }


    fun xunHuanMethod(vararg num : Int){
        for( a in num){
         print("结果打印$a")
            if(a > 5)
                println("大于5结果打印$a")
            else
                println("小于5结果打印$a")
        }

        //在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号
        //这里我们自定义loop@标签
        loop@for( a in num){
            print("结果打印$a")
            if(a > 5){
                //此处如果满足num  > 5则return@loop即跳出loop@标注的for循环，注意不是跳出方法，虽然结果一样
                println("大于5结果打印$a"); return@loop
            }else{
                println("小于5结果打印$a")
            }
        }

        //如：return@a 1，意为“从标签 @a 返回 1”，而不是“返回一个标签标注的表达式 (@a 1)”。

    }
}