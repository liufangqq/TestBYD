package com.byd.firstcode.kotlin.eight

import android.app.IntentService
import android.content.Intent
import android.util.Log

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/03
 * desc :
 * version: 1.0
 * </pre>
 */
class MyIntentService:IntentService("MyIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("MyIntentService","Thread id:${Thread.currentThread().name}");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyIntentService","onDestroy");
    }


}