package com.byd.firstcode.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.lang.StringBuilder

class MainActivity : BaseActivity() {
    val tag = "MainActivity"

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "some";
        outState.putString("data_key", tempData)
    }

    fun addFruit(){
       val list = listOf("Apple","Banana")
        val builder = StringBuilder()
        builder.append("start:\n")
        for(fruit in list){
            builder.append(fruit).append("\n")
        }
        builder.append("ate")
        val result = builder.toString()
        println(result)
    }

    fun addFruit1(){
        val list = listOf("Pear","Grape")
        val result  = with(StringBuilder()){
            append("eating\n")
            for(fruit in list){
                append(fruit).append("\n")
            }
            append("all")
            toString()
        }
        println(result)
    }
    fun addFruit2(){
        val list = listOf("org","pe")
        val result  = StringBuilder().run{
            append("eating\n")
            for(fruit in list){
                append(fruit).append("\n")
            }
            append("all")
            toString()
        }
        println(result)
    }
    fun addFruit3(){
        val list = listOf("org3","pe3")
        val result  = StringBuilder().apply{
            append("eating\n")
            for(fruit in list){
                append(fruit).append("\n")
            }
            append("all ate")
            toString()
        }
        println(result.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Util1.doAction()
//        Util2.doAction()
//        Util3().doAction()
//        Util3.doAction3()
//        Util4().doAction()
//        Util4.doAction4()
//doSomething()


        addFruit3()
        toast(savedInstanceState?.getString("data_key") ?: "test")
        Log.d("test30", "test30:$taskId");
        btn.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("param1", "data1")
//            intent.putExtra("param2", "data2")
//            startActivity(intent)

            val intent = Intent(this,SecondActivity::class.java).apply {
                putExtra("param1","data1")
                putExtra("param2","data2")
            }
            startActivity(intent)

//ActivityCollector.finishAll()
//            startActivity(Intent(this,NormalActivity::class.java))
        }

        btnDialog.setOnClickListener {

            NormalActivity.actionStart(this,"data1","data2")

//            android.os.Process.killProcess(android.os.Process.myPid())

//            val intent = Intent(this,DialogActivity::class.java)
//            startActivity(intent)
        }

//        AlertDialog.Builder(this)

        val book: Book = Book()
        book.pages = 500;
        val bookPages: Int = book.pages;
        toast(bookPages.toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(
            "test21", "test21:requestCode = " + requestCode + ",resultCode = " + resultCode + "," +
                    "data = " + data
        )
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val data = data?.getStringExtra("return")
                toast(data!!)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }
}