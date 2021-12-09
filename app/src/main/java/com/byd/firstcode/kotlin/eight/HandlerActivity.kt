package com.byd.firstcode.kotlin.eight

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_handler.*
import kotlinx.android.synthetic.main.activity_view.*
import org.jetbrains.anko.toast
import java.lang.Exception
import kotlin.concurrent.thread

class HandlerActivity : AppCompatActivity() {
    val context by lazy {
        this
    }
    val progressDialog by lazy {
        ProgressDialog(context)
    }
    val updateText = 1
    val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                updateText -> tv.setText("meet")
            }
        }
    }

   inner class DownloadTask : AsyncTask<Unit, Int, Boolean>() {
        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog.show()
        }

        override fun doInBackground(vararg param: Unit?): Boolean = try {
            while (true) {
                val downloadPercent = doDownload()
                publishProgress(downloadPercent)
                if (downloadPercent >= 100) {
                    break
                }
            }

            true
        } catch (e: Exception) {
            false
        }

        override fun onProgressUpdate(vararg values: Int?) {
            progressDialog.setMessage("Downloaded ${values[0]}%")
        }

        override fun onPostExecute(result: Boolean) {
            progressDialog.dismiss()
            if(result){
                context.toast("succeed")
            }else{
                context.toast("failed")
            }
        }

        fun doDownload():Int=1

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)
        DownloadTask().execute()


        changeTextBtn.setOnClickListener {
            thread {
                val msg = Message()
                msg.what = updateText
                handler.sendMessage(msg)
            }
        }

    }

}