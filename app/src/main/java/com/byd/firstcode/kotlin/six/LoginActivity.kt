package com.byd.firstcode.kotlin.six

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.edit
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import java.io.*

class LoginActivity : BaseActivity() {

    inline fun runRunnable(crossinline block: () -> Unit) {
        val runnable = Runnable {
            block()
        }
        runnable.run()
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputText = accountEdit.text.toString()
        save(inputText)
    }

    private fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }

    private fun save(inputText: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun SharedPreferences.open(block:SharedPreferences.Editor.()->Unit){
        val editor = edit()
        editor.block()
        editor.apply()
    }

    fun doClick(view: View) {
//             finish()
//        val editor = getSharedPreferences("data",Context.MODE_PRIVATE).edit()
//        editor.putString("name","tom")
//        editor.putInt("age",20)
//        editor.putBoolean("married",false)
//        editor.apply()
//        getSharedPreferences("data", Context.MODE_PRIVATE).open {
//            putString("name","Tom1")
//            putInt("age",22)
//            putBoolean("married",true)
//        }

        getSharedPreferences("data", Context.MODE_PRIVATE).edit{
            putString("name","Tom2")
            putInt("age",24)
            putBoolean("married",false)
        }

        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val name = prefs.getString("name", "")
        val age = prefs.getInt("age", 0)
        val married = prefs.getBoolean("married", false)
        Log.d("test10", "name is $name");
        Log.d("test10", "age is $age");
        Log.d("test10", "married is $married");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)
        if (isRemember) {
            val account = prefs.getString("account", "")
            val password = prefs.getString("password", "")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true
        }


        val inputText = load()
        if (inputText.isNotEmpty()) {
            accountEdit.setText(inputText)
            accountEdit.setSelection(inputText.length)
            toast("succeed")
        }

        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if (account == "admin" && password == "123456") {
                 val editor = prefs.edit()
                if(rememberPass.isChecked){
                    editor.putBoolean("remember_password",true)
                    editor.putString("account",account)
                    editor.putString("password",password)
                }else{
                    editor.clear()
                }
                editor.apply()


//                val intent = Intent(this, ReceiverActivity::class.java)
//                startActivity(intent)
//                finish()
            } else {
                toast("invalid")
            }
        }
        test5()
        // test2()
//    test3()
    }


    inline fun printString(str: String, block: (String) -> Unit) {
        println("printString  begin")
        block(str)
        println("printString  end")
    }

    fun test5() {
        println("main start")
        val str = ""
        printString(str) { s ->
            println("lam start")
            if (s.isEmpty())
                return
            println(s)
            println("lam end")
        }
        println("main end")
    }

    fun test1() {
        val num1 = 100
        val num2 = 80
        val result1 = num1AndNum2(num1, num2, ::plus)
        val result2 = num1AndNum2(num1, num2, ::minus)
        toast("$result1---$result2")
    }

    fun test2() {
        val num1 = 100
        val num2 = 80
        val result1 = num1AndNum2(num1, num2) { n1, n2 ->
            n1 + n2
        }
        val result2 = num1AndNum2(num1, num2) { n1, n2 ->
            n1 - n2
        }
        toast("$result1---$result2")
    }

    fun test3() {
        val list = listOf("Apple", "banana")
        val result = StringBuilder().build {
            append("start\n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("ate all.")
        }
        toast(result.toString())

    }
}