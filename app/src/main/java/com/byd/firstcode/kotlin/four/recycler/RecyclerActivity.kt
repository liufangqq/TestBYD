package com.byd.firstcode.kotlin.four.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.byd.firstcode.kotlin.R
import com.byd.firstcode.kotlin.four.Fruit
import kotlinx.android.synthetic.main.activity_recycler.*
import java.lang.StringBuilder

class RecyclerActivity : AppCompatActivity() {
    private val fruitList=ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initFruits()
//        val layoutManager = LinearLayoutManager(this)
        val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager=layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter=adapter
    }

    private fun initFruits(){
        repeat(2){
            fruitList.add(Fruit(getRandomLength("che"),R.drawable.ic_launcher_background))
            fruitList.add(Fruit(getRandomLength("baba"),R.drawable.switch1))
            fruitList.add(Fruit(getRandomLength("water"),R.drawable.ic_launcher_background))
        }
    }

    private fun getRandomLength(str:String):String{
        val n = (1..20).random()
        val build = StringBuilder()
        Log.d("test",n.toString());
        repeat(n){
            build.append(str)
        }
        val content = build.toString()
        Log.d("test1",content);
        return content
    }

}