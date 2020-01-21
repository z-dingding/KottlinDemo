package com.hxzk.kottlindemo.other

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlin.reflect.KClass


class AnnotationActivity : AppCompatActivity() {

    private val TAG = "AnnotationActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.hxzk.kottlindemo.R.layout.activity_annotation)
        //初始化User实例
        val clz = User()
        clz.setNameAndAge("张三", 50).toString()
        //获取自定义类注解CustomerClass注解值
        val clazz = User::class.java
        if (clazz.isAnnotationPresent(CustomerClass::class.java)) {
            //获取自定义CustomerClass注解
            val custom = clazz.getAnnotation(CustomerClass::class.java)
            //获取获取CustomerClass注解的值
            val description = custom.description
            Log.e(TAG, "$description")//结果为:这是一个User数据类
             }
        //获取自定义属性注解的属性值
        val fields = clazz.declaredFields
        for (field in fields) {
            if (field.isAnnotationPresent(CustomerClassProperty::class.java)) {
                val property = field.getAnnotation(CustomerClassProperty::class.java)
                val type = property.type
                val desc = property.description
                //暂时还不知道如何获取字段值，只获取了字段的类型
                Log.e(TAG, "$type")//结果为：class kotlin.Int 或class kotlin.String
                Log.e(TAG, "$desc")//结果为：get()年龄 或get()用户名
            }
        }
    }


    //声明一个注解，用来注解类和接口
    @MustBeDocumented
    //指定注解标注的元素类型为类类型
    @Target(AnnotationTarget.CLASS)
    //指定注解信息可以在运行时被读取
    @Retention(AnnotationRetention.RUNTIME)
    annotation class CustomerClass(val description: String)
    //声明一个注解,注解类中成员属性和函数
    @MustBeDocumented //指定注解信息可以被文档生成工具读取
    //指定注解标注的元素类型为属性类型及允许get,set
    @Target( AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD)
    @Retention(AnnotationRetention.RUNTIME)
    //如果需要对类的主构造函数进行标注，则需要在构造函数声明中添加 constructor 关键字 ，并将注解添加到其前面
    annotation class CustomerClassProperty constructor(
        //KClass<*> 类型表示 KClass 的泛型，* 是泛型通配符，可以是任何类型,允许不传
        val type: KClass<*> = Unit::class,
        val description: String
    )


    /**
     * 使用 CustomerClass 和 CustomerClassProperty 来注解User 类
     */
    @CustomerClass(description = "这是一个User数据类")
     class User {
        @CustomerClassProperty(type = String::class, description = "用户名")
        @field:CustomerClassProperty(type = String::class, description = "get()用户名")
         var name: String? = null

        @CustomerClassProperty(type = Int::class, description = "年龄")
        @field:CustomerClassProperty(type = Int::class, description = "get()年龄")
         var age: Int? = 0

        @CustomerClassProperty(description = "设置姓名和年龄")
        fun setNameAndAge(name: String, age: Int) {
            this.name = name
            this.age = age
        }
        override fun toString(): String {
            return "Person [name=$name, age=$age]"
        }
    }
}
