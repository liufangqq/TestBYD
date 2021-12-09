package com.byd.firstcode.kotlin.four.recycler

import java.lang.StringBuilder

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/21
 * desc :
 * version: 1.0
 * </pre>
 */

fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

operator fun String.times(n:Int) = repeat(n)

//operator fun String.times(n:Int):String{
//    val builder = StringBuilder()
//    repeat(n){
//        builder.append(this)
//    }
//    return builder.toString()
//}