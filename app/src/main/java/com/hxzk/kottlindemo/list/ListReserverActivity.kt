package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class ListReserverActivity : AppCompatActivity() {
    private val TAG = "ListReserverActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_reserver)
        //映射转换
        //mapMethod()
        //双路合并转换
        //zipMethod()
        //关联转换
        //associateWithMethod()
        //打平转换
        //flattenMethod()
        //将集合转化为json数据
        joinToStringAndjoinTo()
    }

    /**
     * 映射转换
     */
    fun mapMethod() {
        val numbers = setOf<Int>(1, 2, 3, 4, 5)
        //基本的映射函数是 map(),作用于元素.只能用it代替元素值，下面结果为：[2, 4, 6, 8, 10]
        val numberMap = numbers.map { it * 2 }
        Log.e(TAG, numberMap.toString())
        //mapIndexed()作用于元素和索引，下面结果为：[0, 2, 6, 12, 20]
        val numberMapindex = numbers.mapIndexed { index, value -> index * value }
        Log.e(TAG, numberMapindex.toString())
        //如果转换在某些元素上产生 null 值，则可以通过调用 mapNotNull() 函数取代 map(),过滤掉null
        // 或 mapIndexedNotNull() 取代 mapIndexed() 来从结果集中过滤掉 null 值。
        val numbernotNull = numbers.mapNotNull { if (it == 2) null else it }
        Log.e(TAG, numbernotNull.toString())//结果为：[1, 3, 4, 5]
        val numbernotNullIndex =
            numbers.mapIndexed { index, value -> if (index == 0 || index == 1) null else index * value }
        //结果为[null, null, 6, 12, 20]
        Log.e(TAG, numbernotNullIndex.toString())
        // mapKeys()函数，转换键，值保持不变，mapValues() 转换值，键保持不变
        val mapExample = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 4)
        val mapChangeKey = mapExample.mapKeys { it.key.toUpperCase() }
        //结果为：{KEY1=1, KEY2=2, KEY3=3, KEY4=4}
        Log.e(TAG, mapChangeKey.toString())
        val mapValues = mapExample.mapValues { it.value + it.key.length }
        //结果为：{key1=5, key2=6, key3=7, key4=8}
        Log.e(TAG, mapValues.toString())
    }

    /**
     * 双路合并(两个集合合并)
     */
    fun zipMethod() {
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")
        //zip()和并两个集合，如果两个集合长度一致
        var animalColors = colors zip animals
        Log.e(TAG, animalColors.toString())// [(red, fox), (brown, bear), (grey, wolf)]
        val twoAnimals = listOf("fox", "bear")
        //zip()和并两个集合，如果两个集合长度不一致
        val twoList = colors.zip(twoAnimals)
        Log.e(TAG, twoList.toString())//结果：[(red, fox), (brown, bear)]
        val a = colors.zip(animals) { color, animal -> "The $animal is $color" }
        Log.e(TAG, a.toString())//结果：[The fox is red, The bear is brown, The wolf is grey]
        val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
        //反解压对列表
        val unzipPairs = numberPairs.unzip()
        Log.e(TAG, unzipPairs.toString())//结果：([one, two, three, four], [1, 2, 3, 4])
        Log.e(TAG, unzipPairs.first.toString())//结果：[one, two, three, four]
        Log.e(TAG, unzipPairs.second.toString())//结果：[1, 2, 3, 4]
    }

    /**
     * 关联转换
     */
    fun associateWithMethod() {
        val numbers = listOf("one", "two", "three", "four")
        //将元素和它们的长度相关联
        val associateWithdList = numbers.associateWith { it.length }
        Log.e(TAG, associateWithdList.toString())//结果为{one=3, two=3, three=5, four=4}
        val associateList = numbers.associateBy { it.first().toUpperCase() }
        Log.e(TAG, associateList.toString())//{O=one, T=three, F=four}
        val associateBy = (numbers.associateBy(keySelector = { it.first().toUpperCase() },
            valueTransform = { it.length }))
        Log.e(TAG, associateBy.toString())//{O=3, T=5, F=4}
    }


    /**
     * 打平
     */
    fun flattenMethod() {
        val listOne = setOf(1, 2, 3)
        val listTwo = setOf(1, 2, 3, 4)
        val numberSets = listOf(listOne, listTwo)
        //flatten()把多个集合合并为一个
        val flattenList = numberSets.flatten()
        Log.e(TAG, flattenList.toString())//结果为：[1, 2, 3, 1, 2, 3, 4]

        val containers = listOf(
            listOf("one", "two", "three"),
            listOf ("four", "five", "six"),
           listOf("seven", "eight")
        )
        val flatMapList=containers.flatMap {element->element}
        val mapList = containers.map { element->element}
        Log.e(TAG, flatMapList.toString())//结果为：[one, two, three, four, five, six, seven, eight]
        Log.e(TAG, mapList.toString())//结果为：[[one, two, three], [four, five, six], [seven, eight]]
    }

    /**
     * 将集合转化为string 数据
     */
    fun joinToStringAndjoinTo(){
        val numbers = listOf("one", "two", "three", "four")
        val joinToString :String =numbers.joinToString()
        Log.e(TAG, joinToString)//结果为： one, two, three, four
        val listString = StringBuffer("The list of numbers: ")
        numbers.joinTo(listString)
        Log.e(TAG, listString.toString())//结果为： The list of numbers: one, two, three, four
        //要构建自定义字符串表示，可以在函数参数分隔符、前缀和后缀中指定其参数
        val numberslist = (1..100).toList()
        println(numberslist.joinToString(limit = 10 ,truncated = "..."))//结果:1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ...
        //要自定义元素本身的表示形式，需要提供transform函数
        //结果:Element: ONE, Element: TWO, Element: THREE, Element: FOUR
        println(numbers.joinToString { "Element: ${it.toUpperCase()}"})
    }
}
