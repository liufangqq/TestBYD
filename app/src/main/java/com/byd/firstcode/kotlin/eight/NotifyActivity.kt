package com.byd.firstcode.kotlin.eight

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.byd.firstcode.kotlin.MainActivity
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_msg.*
import kotlinx.android.synthetic.main.activity_msg.send
import kotlinx.android.synthetic.main.activity_notify.*

class NotifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
            val channel2 = NotificationChannel("important","Important",NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }
        sendNotice.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "normal")
                .setContentTitle("title")
//                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(
//                    resources,R.drawable.switch1
//                )))
                .setStyle(NotificationCompat.BigTextStyle().bigText("text122222222222222222222222222222222222222222222222223444444444444444444435454"))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.switch1))
                .setContentIntent(pi)
//                .setAutoCancel(true)
                .build()
//            manager.notify(1, notification)
            val notification2 = NotificationCompat.Builder(this,"important")
                .setContentTitle("test")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build()
            manager.notify(2,notification2)
        }

        cancelNotice.setOnClickListener {
            manager.cancel(1)
        }

    }
}