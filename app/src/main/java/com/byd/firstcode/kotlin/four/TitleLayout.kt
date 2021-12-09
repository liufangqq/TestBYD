package com.byd.firstcode.kotlin.four

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.title.view.*
import org.jetbrains.anko.toast
/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/17
 * desc :
 * version: 1.0
 * </pre>
 */
class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
       LayoutInflater.from(context).inflate(R.layout.title, this)
        titleBack.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        titleEdit.setOnClickListener{
            context.toast("click")
        }

    }

}