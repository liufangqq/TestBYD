package com.byd.firstcode.kotlin.six

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_receiver.*

class ReceiverActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        forceOffline.setOnClickListener {
            val intent = Intent("com.byd.firstcode.kotlin.FORCE_OFFLINE")
           // intent.setPackage(packageName)
            sendOrderedBroadcast(intent,null)
        }
    }
}