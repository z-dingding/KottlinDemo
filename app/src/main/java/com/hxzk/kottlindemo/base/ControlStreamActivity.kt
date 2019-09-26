package com.hxzk.kottlindemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R
import java.util.*

/**
 * 作者：Created by ${XZT} on 2019/9/1
文件描述：if when while for
 */
class ControlStreamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controlstream)
    }

    /**
     * if的使用
     */
    var largeNum: Int = 0

    fun ifMethod() {
        var a: Int = 1
        var b: Int = 2
        //普通使用
        if (a > b) {
            largeNum = a
        } else {
            largeNum = b
        }
        //作为表达式
        largeNum = if (a > b) a else b
        //if的分支可以是代码块，最后的表达式作为该块的值
        largeNum = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }

        //注意表达式和语句的区别是：表达式需要返回值，有变量接受此值，要有 else 分支
    }


    /**
     * when的使用可以替代Switch
     */
    fun whenMethod(num: Int) {
        when (num) {
            1 -> print("num == $num")
            2 -> print("num == $num")
            else -> {
                print("x is neither 1 nor 2")
            }
        }
        //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔,所以上面的代码也可以这样写
        when (num) {
            1, 2 -> print("num == $num")
            else -> print("x is neither 1 nor 2")
        }
        // when 既可以被当做表达式使用也可以被当做语句使用
        var ressult: String = when (num) {
            1, 2 -> "num == $num"
            else -> "x is neither 1 nor 2"
        }
        //也可以和is结合使用
//    fun Request.getBody() =
//        when (val response = executeRequest()) {
//            is Success -> response.body
//            is HttpError -> throw HttpException(response.status)
//        }
//    }

    }

fun forMethod(list : LinkedList<Int> ){
    //打印集合
   for(num in list){
     print(num)
   }
    //打印集合元素也可以这么写
    for(num in list.indices){
        //打印下标
        print(num)
        print(list[num])
    }

    //倒序遍历就该使用标准库中定义的downTo()函数
    //想不使用1作为遍历的步长，可以使用step()函数
    //步长打个比方从1到10,正常遍历输出是123。。。
    //如果设置了步长为2则会输出：135.。。
    for (num in 100 downTo 0 step 2) {
        println(num)
    }

}

    /**
     * while 和 doWhile 用法和java一样
     * while循环是先判断后循环
     * do-while循环与while循环的不同在于:它先执行循环中的语句,然后再判断表达式是否为真
     * 因此, do-while循环至少要执行一次循环语句。 简单来讲就是说while循环是先循环后判断
     */
    fun daWhileMethod( num : Int){
        do{
            print(num)
        }while (num < 100)
    }
}







