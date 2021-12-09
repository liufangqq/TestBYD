package com.byd.firstcode.kotlin.ten

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.*
import com.byd.firstcode.kotlin.ten.Person
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_jetpack.*
import org.jetbrains.anko.toast

class JetpackActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences
    lateinit var observer: MyObserver

    override fun onStart() {
        super.onStart()
        //   observer.activityStart()
    }

    override fun onStop() {
        super.onStop()
        //  observer.activityStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack)

        val person = intent.getParcelableExtra<Person>("person_data") as Person
       toast(person.name)

        val model:MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        model.refreshResult.observe(this){
            Log.d("test1","test1")
        }

        getUserBtn.setOnClickListener {
            Log.d("test11","test11")
            model.refresh()
//            val userId = (0..10000).random().toString()
//            viewModel.getUser(userId)
        }



        observer = MyObserver(lifecycle)
        lifecycle.addObserver(observer)
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProviders.of(this, MainViewModelFactory(countReserved))
            .get(MainViewModel::class.java)
        viewModel.user.observe(this, Observer {
                user->
            infoText.text = user.firstName
        })
        viewModel.userName.observe(this) {
            toast(it)
        }

        plusOneBtn.setOnClickListener {
            viewModel.plusOne()
        }

        clearBtn.setOnClickListener {
            viewModel.clear()
        }

//        viewModel.counter.observe(this,object:Observer<Int>{
//            override fun onChanged(count: Int?) {
//                infoText.text = count.toString()
//            }
//        })

        viewModel.counter.observe(this) {
            infoText.text = it.toString()
        }
        refreshCounter()
    }

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}