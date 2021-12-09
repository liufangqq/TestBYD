package com.byd.firstcode.kotlin

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/09/09
 * desc :
 * version: 1.0
 * </pre>
 */
class Util4 {
    fun doAction(){
        println("do action4")
    }
    companion object{
        @JvmStatic
        fun doAction4(){
            println("do action44")
        }
    }
}