package com.byd.firstcode.kotlin.eight

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/02
 * desc :
 * version: 1.0
 * </pre>
 */


infix fun String.beginsWith(prefix:String)=startsWith(prefix)

infix fun <T> Collection<T>.has(element:T)=contains(element)

public infix fun <A,B> A.to(that:B):Pair<A,B> = Pair(this,that)
infix  fun <A,B> A.with(that: B):Pair<A,B> = Pair(this,that)