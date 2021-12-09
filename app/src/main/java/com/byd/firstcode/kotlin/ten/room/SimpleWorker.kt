package com.byd.firstcode.kotlin.ten.room

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
class SimpleWorker(context: Context,params:WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        Log.d("SimpleWorker","do work in simple");
//        return Result.retry()
        return Result.success()
    }
}