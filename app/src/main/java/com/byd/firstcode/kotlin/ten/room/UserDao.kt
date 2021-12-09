package com.byd.firstcode.kotlin.ten.room

import androidx.room.*

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
@Dao
interface UserDao {
    @Insert
    fun insertUser(user:User):Long

    @Update
    fun updateUser(newUser:User)

    @Query("select * from User")
    fun loadAllUsers():List<User>

    @Query("select * from User where age > :age")
    fun loadUsersOlderThan(age:Int):List<User>
    @Delete
    fun deleteUser(user:User)

    @Query("delete from User where lastName = :lastName")
    fun deleteUserByLastName(lastName:String):Int
}