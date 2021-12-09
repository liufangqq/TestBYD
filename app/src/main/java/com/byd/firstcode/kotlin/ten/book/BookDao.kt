package com.byd.firstcode.kotlin.ten.book

import androidx.core.view.WindowInsetsCompat
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

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
interface BookDao {
    @Insert
    fun insertBook(book:Book):Long
    @Query("select * from Book")
    fun loadAllBooks():List<Book>
}