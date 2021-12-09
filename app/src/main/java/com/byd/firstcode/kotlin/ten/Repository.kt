package com.byd.firstcode.kotlin.ten

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
object Repository {
    fun getUser(userId: String): LiveData<User> {
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId, userId, 0)
        return liveData
    }

    fun refresh(): LiveData<Any?> = MutableLiveData<Any?>().apply {
        value = value
    }
}