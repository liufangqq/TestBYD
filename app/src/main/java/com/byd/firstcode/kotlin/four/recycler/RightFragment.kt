package com.byd.firstcode.kotlin.four.recycler

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.byd.firstcode.kotlin.R

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/11/19
 * desc :
 * version: 1.0
 * </pre>
 */
class RightFragment:Fragment() {

    companion object{
        const val TAG="RightFragment";
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"onAttach");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate");
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.right_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG,"onActivityCreated");
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop");
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy");
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"onDetach");
    }
}