package com.hxzk.kottlindemo.other

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hxzk.kottlindemo.R

class TypeCheckWithTransLationActivity : AppCompatActivity() {

    private  val TAG ="TypeCheckWithTransLationActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_check_with_trans_lation)
        //var content  ="aaaaaaaaaaaaaa"
        //is操作符
        //isFun(content)
        //as操作符
        asFun()
    }


    /**
     * is 判断类型操作符
     */
    @SuppressLint("LongLogTag")
    fun isFun(content :Any){
        //我们可以通过is操作符判断类型
        if(content is String){
            //此处做了智能转换，编译器足够聪明，能够知道如果反向检测导致返回那么该转换是安全的
            //请注意，当编译器不能保证变量在检测和使用之间不可改变时，智能转换不能用。
         Log.e(TAG,"该参数长度为${content.length}")//该参数长度为14
        }else{
            Log.e(TAG,"该参数非String类型")
        }
    }

    /**
     * as操作符
     */
    @SuppressLint("LongLogTag")
    fun asFun(){
        //as操作符不安全
        //null 不能转换为 String 因该类型不是可空的， 即如果parame为空，下面的代码会抛出一个异常
        //var content =parame as String

        //as避免null异常
         var parame :String? =null
        //为了避免异常可以允许为null
        var content :String? =parame as String?
        Log.e(TAG,"$content")//结果null

        //as?安全
        //尽管事实上 as? 的右边是一个非空类型的 String，但是其转换的结果是可空的。
        var nullContent :String? = parame as? String
        Log.e(TAG,"$nullContent")//结果null
    }
}
