package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R

//定义类型别名,可以直接通过别名Predicate<T>执行(T) -> Boolean
typealias Predicate<T> = (T) -> Boolean
class TypeAliasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_alias)

        fun foo(p: Predicate<Int>) = p(42)
        fun main() {
            val f: (Int) -> Boolean = { it > 0 }
            println(foo(f)) // 输出 "true"

            val p: Predicate<Int> = { it > 0 }
            println(listOf(1, -2).filter(p)) // 输出 "[1]"
        }
    }
}
