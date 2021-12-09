package com.byd.firstcode.kotlin.night

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.byd.firstcode.kotlin.R
import com.byd.firstcode.kotlin.seven.build
import kotlinx.android.synthetic.main.activity_web.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
//        webview.settings.setJavaScriptEnabled(true)
//        webview.webViewClient = WebViewClient()
//        webview.loadUrl("https://www.baidu.com")
        sendRequestBtn.setOnClickListener {
//            sendRequestWithHttpURLConnection()
            sendRequestWithOkhttp()
        }
    }

    private fun sendRequestWithOkhttp() {
        thread {
            val client = OkHttpClient()
            val request = Request.Builder().url("https://www.baidu.com").build()
            val response = client.newCall(request).execute()
            val responseData = response.body?.string()
            if(responseData!=null){
                showResponse(responseData)
            }
        }

    }
    private fun sendRequestWithHttpURLConnection(){
        thread {
            var connection:HttpURLConnection?=null

            val response = StringBuilder()
            val url = URL("https://www.baidu.com")
            connection = url.openConnection() as HttpURLConnection
            connection.connectTimeout = 8000
            connection.readTimeout=8000
            val input = connection.inputStream
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    response.append(it)
                }
            }
            showResponse(response.toString())
            connection.disconnect()
        }
    }

    private fun showResponse(response:String){
        runOnUiThread {
            responseTV.text = response
        }
    }

}