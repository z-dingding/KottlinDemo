package com.hxzk.kottlindemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


/**
 * 作者：Created by ${XZT} on 2019/9/1
文件描述：基本类型：Kotlin 中使用的基本类型：数字、字符、布尔值、数组与字符串
 */
class BaseTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.hxzk.kottlindemo.R.layout.activity_basetype)
        //Kotlin 提供了一组表示数字的内置类型。 对于整数，有四种不同大小的类型，因此值的范围也不同
        //数字
        aboutNumber()
    }


    /**
     * 关于数字
     */
    fun aboutNumber() {
//        类型	大小（比特数）	最小值	最大值
//        Byte	8	-128	127
//        Short	16	-32768	32767
//        Int	32	-2,147,483,648 (-231)	2,147,483,647 (231 - 1)
//        Long	64	-9,223,372,036,854,775,808 (-263)	9,223,372,036,854,775,807 (263 - 1)

        //注：所有以未超出 Int 最大值的整型值初始化的变量都会推断为 Int 类型。
        // 如果初始值超过了其最大值，那么推断为 Long 类型

        //Int类型,未超过Int最大值默认为Int类型
        var intNumber = 1
        //Byte类型,需指定类型不然默认int
        var byteNumber: Byte = 1
        //Short 类型
        var shortNum: Short = 1
        //long类型,超过了Int最大值为long类型，或者在该值后追加 l 或 L 后缀
        var longNumber = 2147483648L

        //对于浮点数，Kotlin 提供了 Float 与 Double 类型两种浮点类型的十进制位数（即可以存储多少位十进制数）不同。
        // Float 反映了 IEEE 754 单精度，而 Double 提供了双精度。
//        类型	     大小（比特数）	有效数字比特数	    指数比特数	十进制位数
//        Float	32	             24           	8	      6-7
//        Double	64		         53             11	     15-16
//        对于以小数初始化的变量，编译器会推断为 Double 类型。
//        如需将一个值显式指定为 Float 类型，请添加 f 或 F 后缀。
//        如果这样的值包含多于 6～7 位十进制数，那么会将其舍入

        //Double类型,对于以小数初始化的变量，编译器会推断为 Double 类型
        var doubleNumber = 3.14
        //值包含多于 6～7 位十进制数，那么会将其舍入
        val eFloat = 2.7182818284f // Float，实际值为 2.7182817
    }


    /**
     * 显示转换
     */
    fun accordingToConversion() {
        //不支持隐式转换,以下是一个错误案例，较小的类型不能隐式转换为较大的类型
        var byteNumber: Byte = 123
//        var intNumber : Int =byteNumber;
        //显示转换
        var intNumber: Int = byteNumber.toInt();
    }


    /**
     * 字符
     */
    fun aboutVhar() {
        //字符用 Char 类型表示。它们不能直接当作数字
        //我们可以显式把字符转换为 Int 数字：
        '0'.toInt() // 显式转换为数字
    }


    /**
     * 数组
     */
    fun aboutArray() {
        //数组在 Kotlin 中使用 Array 类来表示，它定义了 get 与 set 函数（按照运算符重载约定这会转变为 []）以及 size 属性
        //arrayOf() 来创建一个数组并传递元素值给它
        var array = arrayOf('1', '2', '3', '4')
        //[] 运算符代表调用成员函数 get() 与 set()
        var a = array[0]
        //Kotlin 也有无装箱开销的专门的类来表示原生类型数组: ByteArray、 ShortArray、IntArray 等等
    }

    fun aboutString() {
        // 模板表达式以美元符（$）开头，由一个简单的名字构成
        val i = 10
        println("i = $i") // 输出“i = 10”
        //任意表达式
        val s = "abc"
        println("$s.length is ${s.length}") // 输出“abc.length is 3”
        //在原始字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
//        val price = """
//        ${'$'}9.99
//          """
    }
}