package com.byd.firstcode.kotlin.night

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.byd.firstcode.kotlin.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_xml.*
import kotlinx.coroutines.*
//import okhttp3.*
import org.jetbrains.anko.toast
import org.json.JSONArray
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.io.StringReader
import java.lang.Exception
import java.lang.RuntimeException
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class XmlActivity : AppCompatActivity() {

    suspend fun getAppData(){
        try {
            Log.d("test1521","test152:")
            val appList = ServiceCreator.create<AppService>().getAppData().await()
            Log.d("test15","test15:"+appList)
        }catch (e:Exception){
            Log.d("test151","test151:"+e.message)
        }
    }
    suspend fun request(address: String): String {
        return suspendCoroutine { continuation ->
            HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
                override fun onFinish(response: String) {
                    continuation.resume(response)
                }

                override fun onError(e: Exception) {
                    continuation.resumeWithException(e)
                }
            })
        }
    }

    suspend fun getBaiduResponse() {
        try {
            val response = request("https://www.baidu.com/")
            Log.d("test10", "test10:" + response)
        } catch (e: Exception) {
            Log.d("test11", "test11:" + e.message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)
        runBlocking {
//            getBaiduResponse()
            getAppData()
        }

//        val job = GlobalScope.launch {
//        }
//        job.cancel()

//        val job = Job()
//        val scope = CoroutineScope(job)
//        scope.launch {
//
//        }
//        job.cancel()


//printDot()
//        btn.setOnClickListener {
//            val retrofit = Retrofit.Builder().baseUrl("http://10.76.56.101/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
////            val appService = retrofit.create(AppService::class.java)
//            val appService = ServiceCreator.create<AppService>()
//            appService.getAppData().enqueue(object:retrofit2.Callback<List<App>>{
//                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
//                   val list = response.body()
//                    if(list!=null){
//                        for(app in list){
//                            Log.d("XmlActivity", "id is ${app.id}}")
//                            Log.d("XmlActivity", "name is ${app.name}")
//                            Log.d("XmlActivity", "version is ${app.version}}")
//                        }
//                    }
//
//                }
//                override fun onFailure(call: Call<List<App>>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//            })

    }


    //        sendRequestWithOkHttp()
    val address = "http://10.76.56.101/get_data.json"
//        HttpUtil.sendOkHttpRequest(address,object:okhttp3.Callback{
//            override fun onResponse(call: Call, response: Response) {
//          val responseData = response.body?.string()
//                Log.d("test10", responseData?:"error");
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//                TODO("Not yet implemented")
//            }
//        })


//        HttpUtil.sendHttpRequest(address, object : HttpCallbackListener {
//            override fun onFinish(response: String) {
//                Log.d("test1", response);
//            }
//
//            override fun onError(e: Exception) {
//                Log.d("test1", e.message.toString());
//            }
//        })

//    private fun sendRequestWithOkHttp() {
//        thread {
//            val client = OkHttpClient()
//            val request = Request.Builder()
//                .url("http://10.76.56.101/get_data.json")
//                .build()
//            val response = client.newCall(request).execute()
//            val responseData = response.body?.string()
//            if (responseData != null) {
////                parseXMLWithPull(responseData)
////                parseXMLWithSAX(responseData)
////                parseJsonWithJSONObject(responseData)
//                parseJsonWithGSON(responseData)
//            }
//        }
//    }

    private fun parseJsonWithGSON(jsonData: String) {
        Log.d("XmlActivity", "jsonData is ${jsonData}}")
        val gson = Gson()
        val typeOf = object : TypeToken<List<App>>() {}.type
        val appList = gson.fromJson<List<App>>(jsonData, typeOf)
        for (app in appList) {
            Log.d("XmlActivity", "id is ${app.id}}")
            Log.d("XmlActivity", "name is ${app.name}")
            Log.d("XmlActivity", "version is ${app.version}}")
        }
    }

    private fun parseJsonWithJSONObject(jsonData: String) {
        val jsonArray = JSONArray(jsonData)
        for (i in 0 until (jsonArray.length() - 1)) {
            Log.d("XmlActivity", "i is $i")
            val jsonObject = jsonArray.getJSONObject(i)
            val id = jsonObject.getString("id")
            val name = jsonObject.getString("name")
            val version = jsonObject.getString("version")

            Log.d("XmlActivity", "id is $id")
            Log.d("XmlActivity", "id is $name")
            Log.d("XmlActivity", "id is $version")
        }
    }

    private fun parseXMLWithSAX(xmlData: String) {
        val factory = SAXParserFactory.newInstance()
        val xmlReader = factory.newSAXParser().xmlReader
        val handler = ContentHandler()
        xmlReader.contentHandler = handler
        xmlReader.parse(InputSource(StringReader(xmlData)))
    }


    private fun parseXMLWithPull(xmlData: String) {
        val factory = XmlPullParserFactory.newInstance()
        val xmlPullParser = factory.newPullParser()
        xmlPullParser.setInput(StringReader(xmlData))
        var eventType = xmlPullParser.eventType
        var id = ""
        var name = ""
        var version = ""
        while (eventType != XmlPullParser.END_DOCUMENT) {
            val nodeName = xmlPullParser.name
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    when (nodeName) {
                        "id" -> id = xmlPullParser.nextText()
                        "name" -> name = xmlPullParser.nextText()
                        "version" -> version = xmlPullParser.nextText()
                    }
                }
                XmlPullParser.END_TAG -> {
                    if ("app" == nodeName) {
                        Log.d("XmlActivity", "id is $id");
                        Log.d("XmlActivity", "id is $name");
                        Log.d("XmlActivity", "id is $version");
                    }
                }
            }
            eventType = xmlPullParser.next()
        }

    }


}