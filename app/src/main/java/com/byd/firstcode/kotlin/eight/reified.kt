package com.byd.firstcode.kotlin.eight

import android.content.Context
import android.content.Intent

inline fun <reified T> getGenericType()=T::class.java

inline fun <reified T> startActivity(context:Context){
    val intent = Intent(context,T::class.java)
    context.startActivity(intent)
}

inline fun <reified T> startActivity(context:Context,block:Intent.()->Unit){
    val intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}

open class Person(val name:String,val age:Int)
class Student(name:String,age:Int):Person(name,age)
class Teacher(name:String,age:Int):Person(name,age)

public interface  List<out E> :Collection<E>{
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: @UnsafeVariance E): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<E> {
        TODO("Not yet implemented")
    }
    public operator fun get(index:Int):E
}
