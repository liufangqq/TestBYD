package com.byd.firstcode.kotlin.ten.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
@Database(version=1,entities = [User::class])
abstract  class AppDatabase:RoomDatabase() {
abstract fun userDao():UserDao
companion object{
    private var instance:AppDatabase?= null
    @Synchronized
    fun getDatabase(context: Context):AppDatabase{
        instance?.let {
            return it
        }
        return Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"app_database")
            .build().apply {
                instance=this
            }
    }

}

}