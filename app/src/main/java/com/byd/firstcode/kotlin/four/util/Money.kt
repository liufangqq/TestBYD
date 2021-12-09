package com.byd.firstcode.kotlin.four.util

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/21
 * desc :
 * version: 1.0
 * </pre>
 */

class Money(val value:Int){
    operator fun plus(money: Money):Money{
        val sum = value+money.value
        return Money(sum)
    }
    operator fun plus(newValue:Int):Money{
        val sum = value+newValue;
        return Money(sum)
    }

}