package com.byd.firstcode.kotlin.eight

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.byd.firstcode.kotlin.MainActivity
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    lateinit var downloadBinder: MyService.DownloadBinder
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }
    }

    //fun main(){
//    val result1 = getGenericType<String>()
//    val result2 = getGenericType<Int>()
//    println("result1 is $result1")
//    println("result2 is $result2")
//}

    //    fun main() {
//        val student = Student("Tom", 19)
//        val data = SimpleData<Student>(student)
//        handleSimpleData(data)
//        val studentData = data.get()
//    }
    fun main() {
        val trans = object : Transformer<Person> {
            override fun transform(name: String, age: Int): Person {
                return Teacher(name, age)
            }
        }
        handleTransformer(trans)
    }

    fun handleTransformer(trans: Transformer<Student>) {
//        val student = Student("Tom",19)
        val result = trans.transform("Tom", 19)
    }


    fun handleSimpleData(data: SimpleData<Person>) {
        val personData = data.get()
        Log.d("test10", personData.toString());
        val teacher = Teacher("Jack", 35)
//        data.set(teacher)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        main()

        //  startActivity<MainActivity>(this)
//        startActivity<MusicActivity>(this) {
//            putExtra("p1", "1")
//            putExtra("p2", "2")
//        }

        startIntentServiceBtn.setOnClickListener {
            val intent = Intent(this, MyIntentService::class.java)
            startService(intent)
        }
        startServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }
        stopServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
        bindServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
        unbindServiceBtn.setOnClickListener {
            unbindService(connection)
        }
    }
}