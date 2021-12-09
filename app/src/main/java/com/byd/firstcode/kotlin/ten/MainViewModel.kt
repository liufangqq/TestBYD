package com.byd.firstcode.kotlin.ten

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
class MainViewModel(countReserved: Int) : ViewModel() {
    val counter: LiveData<Int>
        get() = _counter
    private val _counter = MutableLiveData<Int>()
    private val userLiveData = MutableLiveData<User>()
    val userName: LiveData<String> = Transformations.map(userLiveData) { user ->
        "${user.firstName} ${user.lastName}"
    }

    init {
        userLiveData.value = User("1", "2", 3)
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }

    private val userIdLiveData = MutableLiveData<String>()
    val user:LiveData<User> = Transformations.switchMap(userIdLiveData){
        userId->
        Repository.getUser(userId)
    }

    fun getUser(userId: String) {
      userIdLiveData.value = userId
    }


}