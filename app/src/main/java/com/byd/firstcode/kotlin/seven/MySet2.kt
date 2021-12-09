package com.byd.firstcode.kotlin.seven

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/30
 * desc :
 * version: 1.0
 * </pre>
 */
class MySet2<T>(val helperSet:HashSet<T>):Set<T> by helperSet {
    fun helloWorld()=println("hello")
    override fun isEmpty(): Boolean =false
}