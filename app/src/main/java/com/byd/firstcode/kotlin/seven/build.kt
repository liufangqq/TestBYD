package com.byd.firstcode.kotlin.seven

import java.lang.StringBuilder

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/30
 * desc :
 * version: 1.0
 * </pre>
 */

fun StringBuilder.build(block:StringBuilder.()->Unit):StringBuilder{
    block()
    return this
}
fun <T> T.build(block:T.()->Unit):T{
    block()
    return this
}

fun <T> later(block:()->T)=Later<T>(block)