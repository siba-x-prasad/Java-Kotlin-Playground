package com.swasi.play.basics

import java.io.File

object VariableExample {

    var age: Int = 0
    var myName: String? = null
    val name: String = ""
    lateinit var mydate: MyData
    lateinit var file: File
    const val myAge = 33
    lateinit var address : String

    @JvmStatic
    fun main(args: Array<String>) {

        myName?.let {
            println("My Name is $myName")
        } ?: println("My Name is Null")

        mydate = MyData("Siba", 33)
        if (this::mydate.isInitialized) {
            println("mydate is Initialized")
        }
        else{
            println("mydate is Not Initialized")
        }

        if (this::file.isInitialized) {
            println("file is Initialized")
        }

        if(this::address.isInitialized){

        }
    }
}

data class MyData(val name: String, val age: Int)