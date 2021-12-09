package com.byd.firstcode.kotlin.ten

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
@Parcelize
class Person(var name:String,var age:Int):Parcelable