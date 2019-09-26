package com.hxzk.kottlindemo.start.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R
import java.lang.Integer.parseInt

/**
 *作者：created by ${zjt} on 2019/8/15
 *描述: 学习基础语法变量的声明和方法的定义
 *
 */
class VarAndFunActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_varandfun)
        //调用成员函数使用点表示法,创建对象然后调用
        var result =VarAndFunActivity().addMethod(1,2)
        //调用函数使用传统的方法
        var resultTwo =addMethodTwo(1,2)
        //可以根据参数名进行赋值,如果有默认值，此时也赋值了参数值,不以默认值为准
        var resultThree =addMethodThree(1,2,parameterThree = 10)
        //可以通过使用星号操作符将可变数量参数（vararg） 以命名形式传入
        var resultFour =addMethodFour(arrayInt =*intArrayOf(1,2,3,4,5))
        //单函数表达式:当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
        //如addMethod()方法可以写成
        var singletonResult = doubleMthod(1,3)
        //采用vararg将数组转化为集合
        //注意:只有一个参数可以标注为 vararg。如果 vararg 参数不是列表中的最后一个参数， 可以使用命名参数语法传递其后的参数的值
        //或者，如果参数具有函数类型，则通过在括号外部传一个 lambda。
        //如果我们已经有一个数组并希望将其内容传给该函数，我们使用伸展（spread）操作符（在数组前面加 *）：
        val a = arrayOf(1, 2, 3)
        var list = VarargsArrayToList(1,2,3,4,5,*a)
        //当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空
        var allowNull =allowNull("789","132")
        //函数的作用域
        //局部函数即Kotlin 支持局部函数，即一个函数在另一个函数内部，局部函数可以访问外部函数（即闭包）的局部变量
        //成员函数是在类或对象内部定义的函数，最常见的一种
        //泛型函数：函数可以有泛型参数，通过在函数名前使用尖括号指定： 如：fun <T> singletonList(item: T): List<T> { …… }
        //内联函数
        //扩展函数
        //高阶函数和 Lambda 表达式
        //尾递归函数

    }


    /**
     * 运行返回null
     */
    fun allowNull(str :String,strtwo:String) : Int?{
        //通过is关键字判断类型
        if(str is String && strtwo is String){
            var x = parseInt(str)
            var y = parseInt(strtwo)
            // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
          if(x != null && y != null){
             return  x * y
          }else{
              return null
          }
            return null
        }

        return null
    }
    //Kotlin 中的函数使用 fun 关键字声明
    //函数参数使用 Pascal 表示法定义，即 name: type。参数用逗号隔开。每个参数必须有显式类型

    fun addMethod(paramesOne : Int, paramesTwo : Int) : Int{
        return paramesOne+paramesTwo
    }

    //addMethod的另一种写法,注意：返回值类型也可以省略,则返回值类型就由编译器推断了
    fun doubleMthod(parameterOne : Int ,parameterTwo : Int): Int = parameterOne+parameterTwo


    //函数参数可以有默认值，当省略相应的参数时使用默认值,默认值通过类型后面的 = 及给出的值来定义
    fun addMethodTwo(paramesOne : Int, paramesTwo : Int,paramesThree : Int = 10) : Int{
        return paramesOne+paramesTwo+paramesThree
    }

    fun addMethodThree(parameter : Int ,parameterTwo : Int ,parameterThree : Int = 5) : Int{
        return parameter+parameterTwo+parameterThree
    }
    
    //vararg表示是可变参数，比如数组
    fun addMethodFour(vararg arrayInt : Int ) : Int{
        var addNum = 0 ;
        for(item in arrayInt){
            //遍历intArr里面的元素，item就是元素本身
            addNum+=item
        }
        return addNum
    }

    /**
     * 采用vararg将数组转化为集合
     */
    fun <T> VarargsArrayToList(vararg array : T) :List<T>{
        var list = ArrayList<T>()
        for(arr in array){
            list.add(arr)
        }
        return list
    }



}