package com.byd.firstcode.kotlin

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/08/17
 * desc :
 * version: 1.0
 * </pre>
 */
open class Person(val name:String,val age:Int){

    fun eat(){
        println("$name is eating,He is $age years old.")
    }

}