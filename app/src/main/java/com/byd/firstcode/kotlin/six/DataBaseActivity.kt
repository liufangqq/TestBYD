package com.byd.firstcode.kotlin.six

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.byd.firstcode.kotlin.R
import java.lang.Exception
import java.lang.NullPointerException

class DataBaseActivity : AppCompatActivity() {
    lateinit var dbHelper: MyDatabaseHelper;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        dbHelper = MyDatabaseHelper(this, "bookstore.db", 3)
    }

    fun doClick(view: View) {
        dbHelper.writableDatabase
    }

    fun test(view:View){
        val db = dbHelper.writableDatabase
        db.beginTransaction()
        try {
            db.delete("Book",null,null)
            if(true){
                throw NullPointerException()
            }
            val values = ContentValues().apply {
                put("name","Game")
                put("author","Mar")
                put("pages",720)
                put("price",28.8)
            }
            db.insert("Book",null,values)
           db.setTransactionSuccessful()
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            db.endTransaction()
        }

    //    db.execSQL("update Book set price = ? where name = ?", arrayOf("10.99","Code"))
//db.execSQL("delete from Book where pages > ?", arrayOf("500"))

//        db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", arrayOf("Code","DanB","454","16.96"))
//        db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", arrayOf("Symbol","Dan","510","19.95"))
    }

    fun update(view: View) {
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put("price", 10.99)
        db.update("Book", values, "name=?", arrayOf("Da"))
    }

    fun delete(view: View) {
        val db = dbHelper.writableDatabase
        db.delete("Book", "pages>?", arrayOf("500"))
    }

    fun query(view: View){
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("select * from Book",null)
//val cursor = db.query("Book",null,null,null,null,null,null)
        if(cursor.moveToFirst()){
            do{
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val author = cursor.getString(cursor.getColumnIndex("author"))
                val pages = cursor.getString(cursor.getColumnIndex("pages"))
                val price = cursor.getString(cursor.getColumnIndex("price"))
                Log.d("test20","name is $name");
                Log.d("test20","author is $author");
                Log.d("test20","pages is $pages");
                Log.d("test20","price is $price");
            }while (cursor.moveToNext())

        }

    }

//    fun cvOf(vararg pairs:Pair<String,Any?>):ContentValues{
//        val cv = ContentValues()
//        for(pair in pairs){
//            val key = pair.first
//            val value = pair.second
//            when(value){
//                is Int -> cv.put(key,value)
//                is Long -> cv.put(key,value)
//                is Short -> cv.put(key,value)
//                is Float -> cv.put(key,value)
//                is Double -> cv.put(key,value)
//                is Boolean -> cv.put(key,value)
//                is String -> cv.put(key,value)
//                is Byte -> cv.put(key,value)
//                is ByteArray -> cv.put(key,value)
//                null ->cv.putNull(key)
//            }
//        }
//        return cv
//    }

    fun cvOf(vararg pairs:Pair<String,Any?>)=ContentValues().apply {
        for(pair in pairs){
            val key = pair.first
            val value = pair.second
            when(value){
                is Int ->put(key,value)
                is Long ->put(key,value)
                is Short ->put(key,value)
                is Float ->put(key,value)
                is Double ->put(key,value)
                is Boolean ->put(key,value)
                is String ->put(key,value)
                is Byte ->put(key,value)
                is ByteArray ->put(key,value)
                null ->putNull(key)
            }
        }
    }


    fun add(view: View) {

        val db = dbHelper.writableDatabase
        val values1 = ContentValues().apply {
            put("name", "Da")
            put("author", "brow")
            put("pages", 454)
            put("price", 16.9)
        }
        db.insert("Book", null, values1)

        val values = cvOf("name" to "Game1","author" to "Mar1","pages" to 721,"price" to 20.81 )
        db.insert("Book",null,values)

//        val values2 = ContentValues().apply {
//            put("name", "lost")
//            put("author", "brown")
//            put("pages", 510)
//            put("price", 19.8)
//        }
//        db.insert("Book", null, values2)

    }


}