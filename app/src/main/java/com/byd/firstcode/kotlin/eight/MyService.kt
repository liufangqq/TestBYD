package com.byd.firstcode.kotlin.eight

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.byd.firstcode.kotlin.R
import kotlin.concurrent.thread

class MyService : Service() {
    private val mBinder = DownloadBinder()

    class DownloadBinder : Binder() {
        fun startDownload() {
            Log.d("MyService", "startDownload");
        }

        fun getProgress(): Int {
            Log.d("MyService", "getProgress");
            return 0
        }
    }


    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "onCreate");
        val manager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel("my_service","前台Service",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val intent = Intent(this,ServiceActivity::class.java)
        val pi = PendingIntent.getActivity(this,0,intent,0)
        val notification = NotificationCompat.Builder(this,"my_service")
            .setContentTitle("title").setContentText("text").setSmallIcon(R.drawable.switch1)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher))
            .setContentIntent(pi).build()
        startForeground(1,notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "onDestroy");
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand");
        thread {
            Thread.sleep(2000)
            stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
    }


}