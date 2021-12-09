package com.byd.firstcode.kotlin

import android.app.Activity

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/09/09
 * desc :
 * version: 1.0
 * </pre>
 */
object ActivityCollector {
    private val activities = ArrayList<Activity>()
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }



}