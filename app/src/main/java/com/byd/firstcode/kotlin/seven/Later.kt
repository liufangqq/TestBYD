package com.byd.firstcode.kotlin.seven

import kotlin.reflect.KProperty

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/30
 * desc :
 * version: 1.0
 * </pre>
 */
class Later<T>(val block:()->T) {
    var value:Any?=null
    operator fun getValue(any:Any?,prop:KProperty<*>):T{
        if(value==null){
            value = block()
        }
        return value as T
    }


}