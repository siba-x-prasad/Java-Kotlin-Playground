package com.swasi.play.coroutines.scope

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    prn()
}

fun prn(){
    val parentJob = MainScope().launch {
        // this is a parent scope
        println("Inside Parent Scope")
    }

    CoroutineScope(parentJob).launch {
        // this is a child scope
        println("Inside Child Scope")
    }
}