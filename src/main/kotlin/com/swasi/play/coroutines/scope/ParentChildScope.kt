package com.swasi.play.coroutines.scope

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    parentChild()
}

fun parentChild(){
    MainScope().launch {
        // this is a parent scope
        println("Inside MainScope parent")
        launch {
            // this is a child scope
            println("Inside Child Scope")
        }
    }
}