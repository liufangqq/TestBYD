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
object StringUtil {
    fun lettersCount(str:String):Int{
        var count=0
        for(char in str){
            if(char.isLetter()){
                count++
            }
        }
        return count
    }
}