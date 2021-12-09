package com.byd.firstcode.kotlin.ten

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
class MyObserver(val lifecycle:Lifecycle):LifecycleObserver {
    init {
       val state =  lifecycle.currentState
        Log.d("MyObserver","state:$state");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
Log.d("MyObserver","activityStart")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.d("MyObserver","activityStop")
    }


}