package com.byd.firstcode.kotlin.night

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
suspend fun <T> Call<T>.await():T{
    return suspendCoroutine {
            continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                Log.d("test153","test153:")
                val body = response.body()
                Log.d("test154","test154:")
                if(body!=null) continuation.resume(body)
                else continuation.resumeWithException(RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.d("test155","test155:")
                continuation.resumeWithException(t)
            }
        })
    }
}
