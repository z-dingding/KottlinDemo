package com.hxzk.kottlindemo.classandobject

//kotlin中的构造函数分为主构造器（primary constructor）和次级构造器（secondary constructor）
//主构造器的写法为：class 类名 constructor(形参1, 形参2, 形参3){}
//对于Primary Constructor而言，它的位置是在类的首部（class header）而不是在类体中（class body）
class VisiableModifierClass constructor( var name :String , var age :Int ,var address :String)  {
     var mName  =""
    var mAge :Int =0
    var mAddress : String ="null"
    //关键字init：init{}它被称作是初始化代码块（Initializer Block），它的作用是为了Primary Constructor服务的把初始化执行语句放置在此处，为属性进行赋值
        init{
            this.mName = name
            this.mAge = age
            this.mAddress = address
    }
}

//当constructor关键字没有注解和可见性修饰符作用于它时，constructor关键字可以省略
//初始化执行语句不是必须放置在init块中,我们可以直接在Primary Constructor中定义类的属性
//所以VisiableModifierClass主构造器可以写为VisiableModifierClassTwo形式
class VisiableModifierClassTwo ( var name :String , var age :Int ,var address :String)  {}

//如果加可见性修饰符就会变为:
class VisiableModifierClassThree private  constructor ( var name :String , var age :Int ,var address :String)  {}