package com.byd.firstcode.kotlin.four.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_main_frg.*

class MainFrgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frag_1)
//        button.setOnClickListener {
//            replaceFragment(RightFragment())
//        }
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.rightLayout, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
}