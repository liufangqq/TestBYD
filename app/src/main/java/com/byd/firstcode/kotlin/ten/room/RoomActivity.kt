package com.byd.firstcode.kotlin.ten.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.observe
import androidx.work.*
import com.byd.firstcode.kotlin.R
import com.byd.firstcode.kotlin.ten.JetpackActivity
import kotlinx.android.synthetic.main.activity_room.*
import kotlin.concurrent.thread
import com.byd.firstcode.kotlin.ten.book.AppDatabase
import java.util.concurrent.TimeUnit
import com.byd.firstcode.kotlin.ten.Person

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        LogUtil.d("TAG","debug log")
        LogUtil.w("TAG","warn log")
//        "This is".showToast()
val person = Person("Tom2",20)
        val intent = Intent(this,JetpackActivity::class.java)
        intent.putExtra("person_data",person)
        startActivity(intent)
        val table = Table()
        table.tr {
            td { "Apple" }
            td { "Apple" }
            td { "Apple" }
        }
        table.tr {
            td { "Pear" }
            td { "Banana" }
            td { "Water" }
        }

//Log.d("test19","test19:"+table.html())

//        val html = table {
//            tr {
//                td { "Apple" }
//                td { "Apple" }
//                td { "Apple" }
//            }
//            tr {
//                td { "Pear" }
//                td { "Banana" }
//                td { "Water" }
//            }
//        }
//        Log.d("test191","test191:"+html)

        val html = table {
            repeat(2){
                tr{
                    val fruits = listOf("App","Gra","Oran")
                    for(fruit in fruits){
                        td { fruit }
                    }
                }
            }
        }
        Log.d("test192","test192:"+html)

        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "bra", 40)
        val user2 = User("Tom", "hanks", 63)

        val libraries = dependencies {
            implementation("com.squareup.retrofit2:retrofit:2.6.1")
            implementation("com.squareup.retrofit2:converter-gson:2.6.1")
        }
        for (lib in libraries) {
            Log.d("test15", "test15:" + lib)
        }


        dowork.setOnClickListener {
            //  val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java)
                // .setInitialDelay(5,TimeUnit.MINUTES)
                .addTag("simple")
                .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
                .build()
//            val request = PeriodicWorkRequest.Builder(SimpleWorker::class.java,15,TimeUnit.MINUTES).build()
            WorkManager.getInstance(this).enqueue(request)
//            WorkManager.getInstance(this).cancelAllWork()
//            WorkManager.getInstance(this).cancelAllWorkByTag("simple")
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id)
                .observe(this) { workInfo ->
                    if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                        Log.d("RoomActivity", "do work success")
                    } else if (workInfo.state == WorkInfo.State.FAILED) {
                        Log.d("RoomActivity", "do work failed")
                    }
                }
        }
        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("hanks")
            }
        }
        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("RoomActivity", user.toString())
                }
            }
        }
    }
}