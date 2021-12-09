package com.byd.firstcode.kotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NormalActivity : AppCompatActivity() {

    companion object{
        fun actionStart(context: Context, data1:String,data2:String){
            val intent = Intent(context,NormalActivity::class.java)
            intent.putExtra("param1",data1)
            intent.putExtra("param2",data2)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        Log.d("test31","test31:$taskId");
    }
}