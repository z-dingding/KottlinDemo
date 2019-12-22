package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hxzk.kottlindemo.R

class SetOperationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_operation)
        //对于集合的过滤操作，没有改变numbers集合的内容
        val numbers = listOf("one", "two", "three", "four")
        numbers.filter { it.length > 3 }
        //过滤操作会返回一个符合过滤条件的新集合,longerThan3的结果为 {three,four}
        val longerThan3 = numbers.filter { it.length > 3 }

       //集合的filterTo()代替filter()将返回的值，直接赋值给指定集合
        val filterResults = mutableListOf<String>()
        //filterTo过滤元素长度>3的结果为：{three,four}
        numbers.filterTo(filterResults) { it.length > 3 }
        //filterIndexedTo上一个操作的结果上继续操作,过滤下标大于0的所以结果为{three,four}+{twothree,four}
        // 结果为{"three", "four"， "two", "three", "four"}
        numbers.filterIndexedTo(filterResults) { index, _ -> index > 0}
        //mapTo()直接将可变list集合转化为map集合，在函数调用的相应参数中直接创建HashSet()类型map，结果为{[0,4],[1,5],[2,3]}
        //应该是it.length为3，也就是获取"one", "two", "three", "four"中的三个，倒序？
        val result = numbers.mapTo(HashSet()) { it.length }


        val num= mutableListOf("one", "two", "three", "four")
        //sorted()创建一个新集合，该集合包含按字母顺序排序但元素不变的相同集合(就是打乱了顺序)，结果为：{four,one,three,two}
        val sortedNumbers = num.sorted()
        println(num == sortedNumbers)  // false
        //sort()就地对可变集合进行排序(对原集合操作没有生成新集合,也是按字母顺序排序)，以便其状态发生变化(就是打乱了顺序)；
        num.sort()
        println(num == sortedNumbers)  // true
    }
}
