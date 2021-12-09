package com.byd.firstcode.kotlin.ten.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
@Entity
data class User(var firstName:String,val lastName:String,var age:Int){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}
