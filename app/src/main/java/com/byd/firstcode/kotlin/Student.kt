package com.byd.firstcode.kotlin

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/08/17
 * desc :
 * version: 1.0
 * </pre>
 */
//class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age) {
//    constructor(name: String, age: Int) : this("", 0, name, age) {
//
//    }
//
//    constructor() : this("", 0) {
//
//    }
//
//}
class Student(val sno: String="", val grade: Int=0, name: String="", age: Int=0) : Person(name, age) {
}