package com.byd.firstcode.kotlin.four.recycler


class Msg(val content:String,val type:Int) {
    companion object{
        const val TYPE_RECEIVED=0
        const val TYPE_SENT=1
    }
}