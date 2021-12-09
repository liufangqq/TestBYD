package com.byd.firstcode.kotlin.six

import java.lang.StringBuilder

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/25
 * desc :
 * version: 1.0
 * </pre>
 */

 inline fun num1AndNum2(num1:Int,num2:Int,operation:(Int,Int)->Int):Int{
    val result = operation(num1,num2)
    return result
}

fun plus(num1:Int,num2:Int):Int{
    return num1+num2;
}
fun minus(num1:Int,num2:Int):Int{
    return num1-num2;
}

fun StringBuilder.build(block:StringBuilder.()->Unit):StringBuilder{
    block()
    return this
}