package com.byd.firstcode.kotlin.six

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.jetbrains.anko.toast

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/25
 * desc :
 * version: 1.0
 * </pre>
 */
class AnotherBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context, p1: Intent?) {
        context.toast("another")
    }
}