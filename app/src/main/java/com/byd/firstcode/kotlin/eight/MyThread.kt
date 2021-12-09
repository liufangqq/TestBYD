package com.byd.firstcode.kotlin.eight

import android.util.Log

class MyThread:Thread() {
    override fun run() {
        super.run()
        Log.d("test10","run");
    }
}