package com.byd.firstcode.kotlin.night

import java.lang.Exception

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/08
 * desc :
 * version: 1.0
 * </pre>
 */
interface HttpCallbackListener {
    fun onFinish(response:String)
    fun onError(e:Exception)
}