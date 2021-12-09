package com.byd.firstcode.kotlin.night

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
object ServiceCreator {

private const val BASE_URL  = "http://10.76.56.101/"
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> create(serviceClass:Class<T>):T = retrofit.create(serviceClass)
inline fun < reified T> create():T = create(T::class.java)

}