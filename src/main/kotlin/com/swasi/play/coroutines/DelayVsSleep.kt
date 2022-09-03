package com.swasi.play.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    launch {
//        Thread.sleep(3000L)
         delay(3000L)
        println("Coroutine 1 ${Thread.currentThread().name}")
    }

    launch {
        println("Coroutine 2 ${Thread.currentThread().name}")
    }
}

/**
 * When you use Thread.sleep(3000)
 *
 * After 3 seconds the below 2 lines will print
 * Because Thread.sleep() will block main thread for 2 seconds to keep JVM alive
 *
 * Coroutine 1 main
   Coroutine 2 main
 *
 *
 * When You Use delay(3000)
 * It will print immediately the first Line because delay don't  block main thread
 * delay block the current coroutines
 * So coroutine 1 main will print after 3 seconds
 *
 * Coroutine 2 main
    Coroutine 1 main
 *
 */