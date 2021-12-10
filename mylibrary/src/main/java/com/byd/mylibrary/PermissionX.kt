package com.byd.mylibrary

import androidx.fragment.app.FragmentActivity

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/10
 * desc :
 * version: 1.0
 * </pre>
 */
object PermissionX {
    private const val TAG = "InvisibleFragment"
//    fun request(
//        activity: FragmentActivity,
//        vararg permissions: String,
//        callback: (Boolean, List<String>) -> Unit
//    ) {
//        val fragmentManager = activity.supportFragmentManager
//        val existedFragment = fragmentManager.findFragmentByTag(TAG)
//        val fragment = if (existedFragment != null) {
//            existedFragment as InvisibleFragment
//        } else {
//            val invisibleFragment = InvisibleFragment()
//            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
//            invisibleFragment
//        }
//        fragment.requestNow(callback, *permissions)
//    }

    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }

}

