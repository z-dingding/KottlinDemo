package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R
import java.util.*

class ConstructorListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constructor_list)
        //基本写法
        //writeLite()
        //复制集合
        copyList()

    }


    /**
     * 集合的基本写法
     */
    fun writeLite(): Unit{
        //创建set集合
        val setLit = setOf("setOne", "setTwo", "setThree")
        //创建set空集合需要指定类型
        val emptey = mutableSetOf<String>()
        //创建set空集合需要指定类型,另一种写法emptySet
        val empty = emptySet<String>()
        //创建map集合，to 符号创建了一个短时存活的 Pair 对象，会消耗性能
        val mapList = mapOf("key1" to "one", "key2" to "two")
        //创建map集合，节约内存使用的写法，需加this,注意是;
        // 创建可写 Map 并使用写入操作填充它。 apply() 函数可以帮助保持初始化流畅。
        val mutableMapList = mutableMapOf<String,String>().apply{
            this["key1"]="one";this["key2"]="two"
        }
        //对于 List，有一个接受 List 的大小与初始化函数的构造函数，该初始化函数根据索引定义元素的值。
        //必须使用it
        val list= List(3,{it * 2})
        println("111111"+list)
        //要创建具体类型的集合，例如 ArrayList 或 LinkedList，可以使用这些类型的构造函数
        val linkedList = LinkedList<String>(listOf("one", "two", "three"))
    }

    /**
     * 复制集合
     */
    fun copyList(){
        //创建可变集合
        val sourceList = mutableListOf<String>("one","two","three")
        //可变集合的值复制给另一个可变集合
        val copyMutableList = sourceList.toMutableList()
        //可变集合的值复制给另一个只读集合，只读集合不能进行add操作
        val copyList =sourceList.toList()
        //改变原数据源数据，但不会影响副本中的元素改变
        sourceList.add("four")
        //副本也可以独立于源集合进行更改，不会影响原数据元素
        copyMutableList.add("five")
        //还可用于将集合转换为其他类型。例如将list转为set
        val copySet = sourceList.toMutableSet()
        //创建对同一集合实例的新引用,当通过引用更改集合实例时，更改将反映在其所有引用中。
        val sourceListTwo =sourceList
        sourceList.add("six")
        println("111111通过引用更改集合实例时，更改将反映在其所有引用中"+sourceListTwo)
        //可以通过其他集合各种操作的结果来创建集合。例如，过滤列表会创建与过滤器匹配的新元素列表：
        //it.length指过滤集合值长度大于3的
        val filterList =sourceList.filter { it.length > 3 }
        println("111111通过过滤创建集合"+filterList)
    }
}