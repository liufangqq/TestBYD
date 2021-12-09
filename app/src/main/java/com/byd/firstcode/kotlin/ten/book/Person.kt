package com.byd.firstcode.kotlin.ten.book

import android.os.Parcel
import android.os.Parcelable

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/12/09
 * desc :
 * version: 1.0
 * </pre>
 */
class Person:Parcelable {
    var name = ""
    var age = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
       return 0
    }
    companion object CREATOR:Parcelable.Creator<Person>{
        override fun createFromParcel(parcel: Parcel): Person {
           val person = Person()
            person.name = parcel.readString()?:""
            person.age = parcel.readInt()
            return person
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }

}