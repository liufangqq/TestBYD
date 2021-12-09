package com.byd.firstcode.kotlin.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_view.*
import org.jetbrains.anko.toast

class ViewActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        button1.setOnClickListener {
            toast("btn1");
        }
        button.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                AlertDialog.Builder(this).apply{
                    setTitle("this")
                    setMessage("some")
                    setCancelable(false)
                    setPositiveButton("OK"){
                        dialog,which->
                        toast("ok1")
                        toast("ok2")
                    }
                    setNegativeButton("Cancel"){
                        dialog,which-> toast("cancel")
                    }
                    show()
                    }

                }

            //    progressBar.setProgress(progressBar.progress+10)

//                if(progressBar.visibility==View.VISIBLE){
//                    progressBar.visibility=View.GONE
//                }else{
//                    progressBar.visibility=View.VISIBLE
//                }


//                imageView.setImageResource(R.drawable.ic_launcher_background)
//               toast("btn")
//             val inputText =    editText.text.toString()
//                toast(inputText)
            }

        }
}