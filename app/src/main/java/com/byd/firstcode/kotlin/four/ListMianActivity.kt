package com.byd.firstcode.kotlin.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_list_mian.*
import org.jetbrains.anko.toast

class ListMianActivity : AppCompatActivity() {
    //    private val data = listOf("Apple", "Banana", "Orange", "water")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_mian)
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        listView.adapter = adapter

        initFruits()
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        listView.adapter = adapter

        listView.setOnItemClickListener{ _,_,position,_->
            val fruit = fruitList[position]
            toast("test")
        }

    }

    private val fruitList = ArrayList<Fruit>()

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.switch1))
        }

    }


}