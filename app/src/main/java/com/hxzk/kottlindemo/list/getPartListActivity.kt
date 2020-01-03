package com.hxzk.kottlindemo.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class getPartListActivity : AppCompatActivity() {

    private  val TAG ="getPartListActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_part_list)
        //sliceFun()
        //takewithdrop()
        //takewhilwithdropwhile()
        //chunkedFun()
        windowedFun()
    }

    fun windowedFun(){
        val list =(0 .. 15).toList()
        //和chunked不太一样，chunked是均分，而windowed()是返回可能的结果
        val windowedList = list.windowed(5)
        Log.e(TAG,windowedList.toString())
        //step定义两个相邻窗口的第一个元素之间的距离,partialWindows包括较小的窗口也就是允许不够5个元素的集合出现
        val windowSettingList =list.windowed(5,step=2,partialWindows = true)
        Log.e(TAG,windowSettingList.toString())
    }

    fun chunkedFun(){
        val list =(0 .. 15).toList()
        //将集合根据指定大小等分
        val difList =list.chunked(5)
        Log.e(TAG,difList.toString())//结果为：[[0, 1, 2, 3, 4], [5, 6, 7, 8, 9], [10, 11, 12, 13, 14], [15]]
        //获取第一等份集合第一个元素
        Log.e(TAG,difList.get(0).get(0).toString())//结果为：0
        //计算每一等分的和
        val sumList =list.chunked(5){it.sum()}
        Log.e(TAG,sumList.toString())//结果为：[10, 35, 60, 15]
    }
    fun takewhilwithdropwhile(){
        val list = listOf("one","two","three","four","five","six")
        //从前往后，第一个元素与第一个与规则不匹配的元素之间的元素集合，但如果第一个集合元素与谓词不匹配，则结果为空
        Log.e(TAG,list.takeWhile { it.length == 3 }.toString())//结果为：[one, two]
        //从后往前，最后一个元素与第一个与规则不匹配的元素之间的元素集合，但如果最后一个集合元素与谓词不匹配，则结果为空
        Log.e(TAG,list.takeLastWhile { it.length == 3 }.toString())//结果为：[six]
        //从前往后，除第一个元素与第一个与规则不匹配的元素之间的元素集合，但如果第一个集合元素与谓词不匹配，则结果为空
        Log.e(TAG,list.dropWhile { it.length == 3 }.toString())//结,果为：[three, four, five, six]
        ///从后往前，除最后一个元素与第一个与规则不匹配的元素之间的元素集合，但如果最后一个集合元素与谓词不匹配，则结果为空
        Log.e(TAG,list.dropLastWhile { it.length == 3 }.toString())//结果为：[one, two, three, four, five]
    }

    /**
     *drop()和take()
     */
    fun takewithdrop(){
        val list = listOf("one","two","three","four","five","six")
        //take()可以打印从第一个元素到指定数量元素的内容集合.与下标无关不从0开始
        Log.e(TAG,list.take(3).toString())//结果为：[one, two, three]，可以理解为前多少个元素
        //takeLast()可以打印从最后一个元素到指定数量元素的内容集合
        Log.e(TAG,list.takeLast(3).toString())//结果为：[four, five, six],可以理解为后多少个元素
        //drop可以打印第一个元素到指定数量的元素之间以外的所有元素集合
        Log.e(TAG,list.drop(1).toString())//结果为：[two, three, four, five, six]，可以理解为除第一个元素以外的所有元素
        Log.e(TAG,list.drop(2).toString())//结果为：[three, four, five, six]可以理解为除一到二元素以外的所有元素
        Log.e(TAG,list.dropLast(5).toString())//结果为：[one]，可以理解为除后五个元素以外的所有元素
    }
    /**
     * slice()
     */
    fun sliceFun(){
       val list = listOf("one","two","three","four","five","six")
        //slice打印一到四个元素，结果为: [one, two, three, four]
        Log.e(TAG,list.slice(0..3).toString())
        //slice打印一到四个元素，跳2步.结果为:[one, three]
        Log.e(TAG,list.slice(0..3 step (2)).toString())
        //slice也可以传入集合,打印第一到第五个元素.结果为:[one, two, three, four, five, six]
        val rangeList= listOf(0,1,2,3,4,5)
        Log.e(TAG,list.slice(rangeList).toString())
    }
}
