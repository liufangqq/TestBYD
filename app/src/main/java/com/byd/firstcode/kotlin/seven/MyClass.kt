package com.byd.firstcode.kotlin.seven

import android.util.Log

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/30
 * desc :
 * version: 1.0
 * </pre>
 */
class MyClass {
    var p by Delegate()
    val p1 by later {
      Log.d("test50","inside")
      "later"
    }

//    fun method(param:T):T{
//        return param
//    }

}