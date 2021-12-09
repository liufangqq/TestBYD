package com.byd.firstcode.kotlin.ten

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
class MyViewModel : ViewModel() {
    private val refreshLiveData = MutableLiveData<Any?>()
    val refreshResult = Transformations.switchMap(refreshLiveData) {
        Log.d("test12","test12")
        Repository.refresh()
    }

    fun refresh() {
        refreshLiveData.value = refreshLiveData.value
    }

}