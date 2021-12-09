package com.byd.firstcode.kotlin.eight

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.byd.firstcode.kotlin.R
import kotlinx.android.synthetic.main.activity_music.*
import org.jetbrains.anko.toast
import kotlin.concurrent.thread

class MusicActivity : AppCompatActivity() {
    private val mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        videoview.setVideoURI(uri)
        thread {
            Log.d("test13","run");
        }

//        Thread{
//            Log.d("test12","run");
//        }.start()

//        val myThread = MyThread1()
//        Thread(myThread).start()
        // MyThread().start()

        //   toast(mapOf("app" with  1).size.toString())


//        if("hello world".startsWith("hello")){
//            toast("yes")
//        }

//        if ("hello world" beginsWith "hello") {
//            toast("suc")
//        }
        val list = listOf("apple", "banana", "orange")
//        if (list.contains("banana")) {
//            toast("yes1")
//        }
//        if (list has "banana") {
//            toast("suc1")
//        }

        initMediaPlayer()
        play.setOnClickListener {
//            if (!mediaPlayer.isPlaying) {
//                mediaPlayer.start()
//            }

            if (!videoview.isPlaying) {
                videoview.start()
            }
        }

        pause.setOnClickListener {
//            if (mediaPlayer.isPlaying) {
//                mediaPlayer.pause()
//            }
            if (videoview.isPlaying) {
                videoview.pause()
            }
        }
        replay.setOnClickListener {
            if (videoview.isPlaying) {
                videoview.resume()
            }
        }

        stop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.reset()
                initMediaPlayer()
            }
        }

    }

    private fun initMediaPlayer() {
        val assetManager = assets
        val fd = assetManager.openFd("music.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
//        mediaPlayer.stop()
//        mediaPlayer.release()
        videoview.suspend()
    }

}