package com.byd.firstcode.kotlin.four.recycler

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.byd.firstcode.kotlin.R
import com.byd.firstcode.kotlin.four.util.Money
import com.byd.firstcode.kotlin.four.util.StringUtil
import kotlinx.android.synthetic.main.activity_news_content.*
import org.jetbrains.anko.toast

class NewsContentActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context,title:String,content:String){
            val intent = Intent(context,NewsContentActivity::class.java).apply {
                putExtra("news_title",title)
                putExtra("news_content",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        val str = "def1"*3
        toast(str)
//        val str = "abcdf";
//        val count = StringUtil.lettersCount(str)
//        toast("abs".lettersCount().toString())
        val money1 = Money(5)
        val money2 = Money(10)
        val money3=money1+money2
        val money4 = money3+20
        toast(money4.value.toString())

        val title=intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        if(title!=null && content!=null){
            val fragment = newsContentFrag as NewsContentFragment
            fragment.refresh(title,content)
        }

    }
}