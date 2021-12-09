package com.byd.firstcode.kotlin.eight

import android.util.Log

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/02
 * desc :
 * version: 1.0
 * </pre>
 */
class MyThread1:Runnable {
    override fun run() {
        Log.d("test11","run");
    }
}