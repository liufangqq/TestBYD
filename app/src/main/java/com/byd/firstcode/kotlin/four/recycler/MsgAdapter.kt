package com.byd.firstcode.kotlin.four.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byd.firstcode.kotlin.R
import java.lang.IllegalArgumentException

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/18
 * desc :
 * version: 1.0
 * </pre>
 */
class MsgAdapter(val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {

//    inner class LeftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
//    }
//    inner class RightViewHolder(view:View):RecyclerView.ViewHolder(view){
//        val rightMsg:TextView = view.findViewById(R.id.rightMsg)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder =
        if (
            viewType == Msg.TYPE_RECEIVED) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            LeftViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent,false)
            RightViewHolder(view)
        }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position];
        when(holder){
            is LeftViewHolder ->holder.leftMsg.text=msg.content
            is RightViewHolder ->holder.rightMsg.text=msg.content
        }
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position];
        return msg.type
    }

    override fun getItemCount(): Int = msgList.size
}