package com.hxzk.kottlindemo.start.habitusage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

/**
 *作者：created by ${zjt} on 2019/8/21
 *描述:习惯用法类，目的规范kotlin开发习惯
 *
 */
class HabitUsageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var userOne = UserBean("张三", 18, "123456789")
        var userTwo = UserBean("张三", 18, "123456789")

        var componentName = userOne.component1()
        var componentAge = userOne.component2()
        var componentId = userOne.component3()
        //也可以这么写
        //多重赋值
        var (name, age, id) = userOne
        println("$name" + "$age" + "$id")

        //copy(),将对象的值赋值给当前对象
        var other: UserBean = userOne.copy(userName = "张三改为王五", userAge = 25)

        println(userOne.toString())
        println(other.toString())
        println(userTwo.toString())
        //hashCode方法实际上返回的就是对象存储的物理地址
        //如果两个对象相同，那么它们的hashCode值一定要相同,值的是用eqauls方法比较
        println(userOne.hashCode())
        println(userTwo.hashCode())
        println(userOne.equals(userTwo))

        var list = LinkedList<Int>()
        list.add(15)
        list.add(18)
        list.add(21)
        list.add(24)
        var va: Int = 0
        //参数有默认值，集合过滤，检测元素是否存在于集合中
        var allNum = addMethod(10, va, list)
        //when类型判断
        varType(123)
        //循环map类型集合
        //创建Map集合方式通过to或者Pair,区别好像是一个是正序一个是倒叙
        var map: HashMap<String, String> = hashMapOf("1" to "one", "2" to "two", "3" to "three")
        var mapTwo: HashMap<String, String> = hashMapOf(Pair("4", "four"), Pair("5", "five"), Pair("6", "six"))
        var mapList = LinkedList<HashMap<String, String>>()
        mapList.add(map)
        mapList.add(mapTwo)
        inMapList(mapList)

        //只读 list
        val listof = listOf("a", "b", "c")
        //只读 map
        val mapOf = mapOf("a" to 1, "b" to 2, "c" to 3)
        //访问 map
        var hashMap: HashMap<String, String> = hashMapOf("key" to "123")
        println(hashMap["key"])
        hashMap["key"] = "456"
        println(hashMap["key"])
        //by lazy 在属性被第一次被使用的时候能自动初始化
        val byLazy: String by lazy { "by_lazy" }
        println(byLazy)
        //Koltin中属性在声明的同时也要求要被初始化，否则会报错.如下：
        //var vairable :String
        //ateinit var的作用也比较简单，就是让编译期在检查时不要因为属性变量未被初始化而报错。
        lateinit var vairableLateinint: String

        //扩展函数
        var sentence = "space to camel case"
        sentence.spaceToCamelCase()
        //单例调用方法
        SingltTon.name = "单例模式调用方法打印"
        SingltTon.toPrintLn()

        //允许变量或者对象为空即if not null
        //在声明对象时，把它跟在类名后面，表示这个类允许为null；
        //在调用对象时，把它跟在对象后面，表示如果为null程序就会视而不见。
        ifNotNull()
        //交换两个变量值
        exchangeVariable(1,2)
    }


    //data class就是一个数据类中只包含一些数据字段，类似于java bean
    //编译器在背后默默给我们生成toString(),equals()/hashCode(),componentN(),copy()等方法
    //主构造函数中的所有参数必须被标记为var或者val，var就表示可读写，val就表示只读，
    data class UserBean(var userName: String, var userAge: Int = 20, val userId: String) {
        //可以自己重写toString方法
        override fun toString(): String {
            return "[User(userName = $userName,userAge = $userAge)]"
        }
    }


    /**
     * 计算加法
     * 参数有默认值，集合过滤，检测元素是否存在于集合中
     */
    fun addMethod(numberOne: Int, numberTwo: Int = 18, list: LinkedList<Int>): Int {
        var allNum = 0
        //filter()过滤 list
        var filterList = list.filter { it > 18 }
        for (num in filterList) {
            //检测元素是否存在于集合中
            if (18 !in filterList) {
                allNum += num
            }
        }
        return numberOne + numberTwo + allNum
    }


    /**
     * when 类型判断
     */
    fun varType(obj: Any) {
        when (obj) {
            is String -> println("String类型")
            is Int -> println("Int类型")
            is Double -> println("Double类型")
            else -> println("未知类型")
        }

    }

    /**
     * 循环map类型集合
     */
    fun inMapList(mapList: LinkedList<HashMap<String, String>>) {
        for (map in mapList) {
            for ((k, v) in map) {
                println("$k" + "$v")
            }
        }
    }


    /**
     * 扩展函数,相当于为String类扩展了一个方法spaceToCamelCase
     * 此方法作用：来将一个句子转换为驼峰字符串并打印出来
     */
    fun String.spaceToCamelCase() {
        var camelTest = this.split(" ")
            .map { it.replaceFirst(it[0], it[0].toUpperCase()) }
            .joinToString("")
        println(camelTest)
    }


    /**
     * 创建单例
     * 用object关键字来修饰就行，这种单例相当于单例中的饿汉模式
     */
    object SingltTon {
        var name = "123456"
        fun toPrintLn() {
            println(name)
        }
    }

    /**
     * if not null 允许变量或者类名为null，我们知道kotlin默认对象或者变量是进行非空判断的
     */
    fun ifNotNull() {
        //创建一个集合,只有加了?,才允许改变量为空，否则代码报错
        var list : ArrayList<String>? =null
        //因为加上了问号，所以可以任意的把list变成空
        println("is not null 缩写"+list?.size)
        //If not null and else 缩写
        println(list?.size ?: "empty")
        //If not null and else这样写不对
        println("is not null 缩写"+list?.size ?: "empty")
        //if null 执行
        //val nullList =println(list?.get(0) ?: throw IllegalStateException("nullList is missing!"))
    }

    /**
     * 交换两个变量值,把a和b的值互换
     */
    fun exchangeVariable(a :Int , b:Int){
        var a = a
        var b = b
        a = b.also { b = a }
        println(a)
        println(b)

    }
}


