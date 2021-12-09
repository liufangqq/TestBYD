package com.byd.firstcode.kotlin.four.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.news_content_frag.*

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/21
 * desc :
 * version: 1.0
 * </pre>
 */
class NewsContentFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_content_frag,container,false)
    }
    fun refresh(title:String,content:String){
        contentLayout.visibility=View.VISIBLE
        newsTitle.setText(title)
        newsContent.setText(content)
    }

}