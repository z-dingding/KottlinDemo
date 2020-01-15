package com.hxzk.kottlindemo.list

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class MapOperationActivity : AppCompatActivity() {
    private val TAG = "MapOperationActivity"
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_opration)
        //map集合的获取操作
        // mapGetValue()
        //map的过滤操作
        //mapFilter()
        //map集合的增加删除操作
        //mapAddWithReduce()
        //map集合的写操作
        //mapWriter()
        //map的删除操作
        mapDelete()
    }

    /**
     * map的删除操作
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun  mapDelete(){
        val mutalMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3,"four" to 4,"five" to 5)
        //要从可变 Map 中删除条目，请使用 remove() 函数
        //调用 remove() 时可以传递键
        mutalMap.remove("one")
        Log.e(TAG,"$mutalMap") //结果为:{two=2, three=3, four=4, five=5}
        //调用 remove() 时可以传递整个键值对,仅当键值都匹配时，才会删除此的元素
        mutalMap.remove("two" , 2)
        Log.e(TAG,"${mutalMap}")//结果为:{three=3, four=4, five=5}
        //在 Map 的 .keys中调用 remove() 并提供键来删除
        mutalMap.keys.remove("three")
        Log.e(TAG,"$mutalMap")//结果为:{four=4, five=5}
        //在 Map 的 .values中调用 remove() 并提供值来删除，仅删除给定值匹配到的的第一个条目
        mutalMap.values.remove(4)
        Log.e(TAG,"${ mutalMap}")//结果为:{five=5}
        //minusAssign （-=） 操作符也可用于可变 Map
        mutalMap -= "five"
        Log.e(TAG,"$mutalMap")//结果为:{}
    }

    /**
     * map的写操作
     */
    fun mapWriter(){
        val mutalMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
        //要将新的键值对添加到可变 Map ，请使用 put()
        mutalMap.put("four" , 4)
        Log.e(TAG,"$mutalMap")//结果为:{one=1, two=2, three=3, four=4}
        //要一次添加多个条目，请使用 putAll()
        val map = mapOf("four" to  4,"five" to 5,"six" to 6)
        mutalMap.putAll(map)
        Log.e(TAG,"$mutalMap")//结果为:{one=1, two=2, three=3, four=4, five=5, six=6}
        //如果给定键已存在于 Map 中，则 put() 与 putAll() 都将覆盖值。 因此，可以使用它们来更新 Map 条目的值
        mutalMap.put("four" , 100)
        Log.e(TAG,"${mutalMap}")//结果为: {one=1, two=2, three=3, four=100, five=5, six=6}
        //还可以使用快速操作符将新条目添加到 Map 。 有两种方式：
        //第一个中[] 操作符为 put() 的别名
        mutalMap["seven"] = 7
        Log.e(TAG,"$mutalMap")//结果为:{one=1, two=2, three=3, four=100, five=5, six=6, seven=7}
        //第二个plusAssign （+=） 操作符
        mutalMap += mapOf("eight" to 8, "nine" to 9)
        Log.e(TAG,"$mutalMap")//结果为:{one=1, two=2, three=3, four=100, five=5, six=6, seven=7, eight=8, nine=9}
    }

    /**
     * map集合的获取操作
     */
    fun mapGetValue() {
        val map = mapOf("one" to 1, "two" to 2, "three" to 3)
        //通过get()依据key获取value,如果找不到给定的键，则返回 null
        Log.e(TAG, "通过get()获取value${map.get("two")}")//结果为：2
        //也可以简写map[key]
        Log.e(TAG, "通过get()获取value简写${map["one"]}")//结果为：1
        //getOrElse() 与 list 的工作方式相同：对于不存在的键，其值由给定的 lambda 表达式返回
        Log.e(TAG, "${map.getOrElse("four", { 5 })}")//结果为：5
        //getOrDefault() 如果找不到键，则返回指定的默认值
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Log.e(TAG, "${map.getOrDefault("four", 8)}")//结果为：8
        }
        //map 的所有键或所有值执行操作，可以从属性 keys 和 values 中相应地检索它们
        //keys 是 Map 中所有键的集合， values 是 Map 中所有值的集合。
        Log.e(TAG, "${map.keys}")//结果为：[one, two, three]
        Log.e(TAG, "${map.values}")//结果为：[1, 2, 3]
    }

    /**
     * map的过滤操作
     */
    fun mapFilter() {
        val map = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5)
        //map通过filter() 函数来过滤 map 或其他集合。
        val mapfilter = map.filter { (key, value) -> key.length > 3 && value > 3 }
        Log.e(TAG, "$mapfilter")//结果为： {four=4, five=5}
        //filterKeys() 的谓词仅检查元素键,返回一个新 Map
        Log.e(TAG, "${map.filterKeys { it.startsWith("t") }}")//结果为：{two=2, three=3}
        //filterValues() 的谓词仅检查值,返回一个新 Map
        Log.e(TAG, "${map.filterValues { it >4}}")//结果为：{five=5}
    }

    /**
     * map集合的plus和minus操作,注意plus(+)只是返回新集合，不影响原map
     */
    fun mapAddWithReduce(){
        val map = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5)
        //+操作来添加一个键值对不会改变原map
        Log.e(TAG,"${map + Pair("six" ,6)}") //结果为:{one=1, two=2, three=3, four=4, five=5, six=6}
        //put()来添加一个键值对会改变原map
        map.put("six" ,6)
        Log.e(TAG,"$map")//结果为:{one=1, two=2, three=3, four=4, five=5, six=6}
        //+操作如果添加了同一个key，那么之前的value将被覆盖
        Log.e(TAG,"${map + Pair("one" ,11)}") //结果为:{one=11, two=2, three=3, four=4, five=5, six=6}
        //+操作也可以是一个map
        val mapAdd =mapOf("seven" to 7 ,"eight" to 8)
        Log.e(TAG,"${map + mapAdd}") //结果为:{one=1, two=2, three=3, four=4, five=5, six=6, seven=7, eight=8}
        //-操作可以删除指定key的键值对
        Log.e(TAG,"${map - "two"}")//结果为:{one=1, three=3, four=4, five=5, six=6}
        //-操作对象可以是list 、 set 等
        val list = listOf("one" ,"two","three")
        Log.e(TAG,"${map - list}")//结果为:{four=4, five=5, six=6}
    }


}
