package com.byd.firstcode.kotlin.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.byd.firstcode.kotlin.R

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        supportActionBar?.hide()
    }
}