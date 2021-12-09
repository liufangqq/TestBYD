package com.byd.firstcode.kotlin.four.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.jetbrains.anko.toast

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/21
 * desc :
 * version: 1.0
 * </pre>
 */
class BootCompleteReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
       context?.toast("complete")
    }
}