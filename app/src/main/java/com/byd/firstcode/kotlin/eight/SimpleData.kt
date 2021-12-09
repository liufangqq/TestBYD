package com.byd.firstcode.kotlin.eight

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/03
 * desc :
 * version: 1.0
 * </pre>
 */
class SimpleData<out T>(val data:T?) {
//    private var data:T?=null
//    fun set(t:T?){
//        data = t
//    }
    fun get():T?{
        return data
    }
}