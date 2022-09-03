package com.swasi.play.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Hello!")
    doWorldSuspendFunction()
}

suspend fun doWorldSuspendFunction(){
    delay(1000L)
    println("World!")
}