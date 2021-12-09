package com.byd.firstcode.kotlin.night

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/08
 * desc :
 * version: 1.0
 * </pre>
 */
interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
    @GET("get_data.json")
    fun getData1():Call<Data>
    @GET("{page}/get_data.json")
    fun getData2(@Path("page")page:Int):Call<Data>
    @GET("get_data.json")
    fun getData3(@Query("u")user:String,@Query("t")token:String):Call<Data>
    @DELETE("data/{id}")
    fun deleteData():Call<ResponseBody>
    @POST("data/create")
    fun createData(@Body data:Data):Call<ResponseBody>
    @Headers("User-Agent:okhttp","Cache-Control:max-age=0")
    @GET("get_data.json")
    fun getData4():Call<Data>

    @GET("get_data.json")
    fun getData5(@Header("User-Agent")userAgent:String,@Header("Cache-Control")cacheControl:String):Call<Data>
}