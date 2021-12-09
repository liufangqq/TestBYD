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
interface Transformer<in T> {
    fun transform(name:String,age:Int):@UnsafeVariance T
}