package com.hxzk.kottlindemo.classandobject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hxzk.kottlindemo.R

/**
 * 密封类
 */
class SealClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealclass)
       var animalTyep = animalTyep(Animal.Flower("牡丹花"))
        println(animalTyep)
    }
    fun animalTyep(animal: Animal) : String  =  when (animal){
            is Animal.Flower -> "花类:" + animal.animalName
            is Animal.Bird -> "鸟类:" + animal.animalName
            is Animal.Fish -> "鱼类:" + animal.animalName
            is Animal.Insect -> "虫类" + animal.animalName
            else -> "您输入的物种暂时无法识别"
    }
    sealed class Animal {
        data class Flower(var animalName: String) : Animal()
        data class Bird(var animalName: String) : Animal()
        data class Fish(var animalName: String) : Animal()
        data class Insect(var animalName: String) : Animal()
    }

}
