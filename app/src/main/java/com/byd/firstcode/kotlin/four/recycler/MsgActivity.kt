package com.byd.firstcode.kotlin.four.recycler

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_msg.*
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.activity_recycler.recyclerView
import org.jetbrains.anko.toast

class MsgActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>();
    private lateinit var adapter:MsgAdapter

    inner class  TimeChangeReceiver:BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
           toast("time changed")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    lateinit var timeChangeReceiver: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg)
        val filter = IntentFilter()
//        filter.addAction("android.intent.action.TIME_TICK")
//        timeChangeReceiver = TimeChangeReceiver()
//        registerReceiver(timeChangeReceiver,filter)


     //   NewsContentActivity.actionStart(this,"12","34")

      val msg =   getResultMsg(Success("yes23"))
        toast(msg!!)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        if(!::adapter.isInitialized){
            adapter = MsgAdapter(msgList)
        }
        recyclerView.adapter=adapter
        send.setOnClickListener(this)
    }

    private fun initMsg(){
        val msg1=Msg("Hello guy.",Msg.TYPE_RECEIVED)
        val msg2 = Msg("Who?",Msg.TYPE_SENT)
        msgList.add(msg1)
        msgList.add(msg2)
        val msg3=Msg("Nice",Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }

    override fun onClick(v: View?) {
        when(v){
            send ->{
                val content = inputEdit.text.toString()
                if(content.isNotEmpty()){
                    val msg = Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size-1)
                    recyclerView.scrollToPosition(msgList.size-1)
                    inputEdit.setText("")
                }
            }
        }


    }
}